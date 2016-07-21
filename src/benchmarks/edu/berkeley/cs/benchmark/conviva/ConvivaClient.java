package edu.berkeley.cs.benchmark.conviva;

import edu.brown.api.BenchmarkComponent;
import edu.brown.logging.LoggerUtil;
import edu.brown.logging.LoggerUtil.LoggerBoolean;
import org.apache.log4j.Logger;
import org.voltdb.client.ClientResponse;
import org.voltdb.client.ProcedureCallback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * SLOG Client
 * @author anuragk
 */
public class ConvivaClient extends BenchmarkComponent {
    private static final Logger LOG = Logger.getLogger(ConvivaClient.class);
    private static final LoggerBoolean debug = new LoggerBoolean();
    static {
        LoggerUtil.attachObserver(LOG, debug);
    }

    public class SearchQuery {
        SearchQuery(int fieldIdx, String param) {
            this.attrId = fieldIdx;
            this.attrValue = param;
        }
        public int attrId;
        public String attrValue;
    }

    private int initNumRecords;
    private final ArrayList<Integer> queryTypes;
    private final ArrayList<Long> keys;
    private final ArrayList<SearchQuery> searchQueries;
    private final ArrayList<String[]> insertRecords;

    private int opNum;
    private long curKey;

    public static void main(String args[]) {
        BenchmarkComponent.main(ConvivaClient.class, args, false);
    }

    public ConvivaClient(String args[]) {
        super(args);

        String insertsFile = "~/data.inserts";
        String queryFile = "~/data.queries";
        String queryDistribution = "0.34|0.33|0.33|0.00";
        int numRecords = ConvivaConstants.NUM_RECORDS;
        for (String key : m_extraParams.keySet()) {
            String value = m_extraParams.get(key);

            // Number of records to load
            if (key.equalsIgnoreCase("num_records")) {
                numRecords = Integer.valueOf(value);
            }
            // Inserts File
            else if (key.equalsIgnoreCase("inserts_file")) {
                insertsFile = String.valueOf(value);
            }
            // Query File
            else if (key.equalsIgnoreCase("query_file")) {
                queryFile = String.valueOf(value);
            }
            // Query Distribution
            else if (key.equalsIgnoreCase("query_distribution")) {
                queryDistribution = String.valueOf(value);
            }
        } // FOR

        // Log all parameters
        LOG.info("Initial number of records: " + numRecords);
        LOG.info("Query Distribution: " + queryDistribution);
        LOG.info("Query file: " + queryFile);
        LOG.info("Inserts file: " + insertsFile);
        LOG.info("Client ID: " + getClientId());

        this.initNumRecords = numRecords;

        String[] dist = queryDistribution.split("\\|");
        double getMark = Double.parseDouble(dist[0]);
        double searchMark = getMark + Double.parseDouble(dist[1]);
        double insertMark = searchMark + Double.parseDouble(dist[2]);
        double deleteMark = insertMark + Double.parseDouble(dist[3]);
        assert (deleteMark == 1.0);

        LOG.info("Loading insert records...");
        this.insertRecords = new ArrayList<String[]>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(insertsFile));
            String valueString;
            int numInsertRecords = 0;
            while (numInsertRecords < ConvivaConstants.QUERY_COUNT && (valueString = br.readLine()) != null) {
                String[] fields = valueString.split("\\|");
                this.insertRecords.add(fields);
                numInsertRecords++;
            }
            br.close();
        } catch (IOException e) {
            LOG.error("Could not open file " + insertsFile + " : " + e.getMessage(), e);
            System.exit(-1);
        }

        LOG.info("Loading search queries...");
        this.searchQueries = new ArrayList<SearchQuery>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(queryFile));
            String queryString;
            int numQueries = 0;
            while (numQueries < ConvivaConstants.QUERY_COUNT && (queryString = br.readLine()) != null) {
                String[] queryParts = queryString.split("\t");
                searchQueries.add(new SearchQuery(Integer.parseInt(queryParts[0]), queryParts[1]));
                numQueries++;
            }
            br.close();
        } catch (IOException e) {
            LOG.error("Could not open file " + queryFile + " : " + e.getMessage(), e);
            System.exit(-1);
        }

        Random randGen = new Random();
        this.queryTypes = new ArrayList<Integer>();
        for (int i = 0; i < ConvivaConstants.QUERY_COUNT; i++) {
            final double r = randGen.nextDouble();
            if (r < getMark) {
                this.queryTypes.add(0);
            } else if (r < searchMark) {
                this.queryTypes.add(1);
            } else if (r < insertMark) {
                this.queryTypes.add(2);
            } else if (r < deleteMark) {
                this.queryTypes.add(3);
            }
        }

        LOG.info("Loading keys...");
        this.keys = new ArrayList<Long>();
        for (int i = 0; i < ConvivaConstants.QUERY_COUNT; i++) {
            this.keys.add(randGen.nextLong() % this.initNumRecords);
        }

        this.opNum = 0;
        long id = this.getClientId();
        long multiplier = Integer.MAX_VALUE;
        this.curKey = (long)initNumRecords + id * multiplier;
        LOG.info("Starting key = " + curKey);
        LOG.info("Loading done.");
    }

    @SuppressWarnings("unused")
    @Deprecated
    @Override
    public void runLoop() {
        try {
            while (true) {
                runOnce();
            }
        } catch (IOException e) {
            LOG.error("Benchmark error : " + e.getMessage(), e);
            System.exit(-1);
        }
    }

    @Override
    public boolean runOnce() throws IOException {

        // Next query
        int queryType = queryTypes.get(opNum % queryTypes.size());
        Object params[];
        int procIdx;
        String procName;

        switch (queryType) {
            case 0:
                procIdx = 0;
                procName = "ReadRecord";
                params = new Object[] { keys.get(opNum % keys.size()) };
                break;
            case 1:
                procIdx = 1;
                procName = "SearchField";
                SearchQuery query = searchQueries.get(opNum % searchQueries.size());
                params = new Object[] { query.attrId, query.attrValue};
                break;
            case 2:
                procIdx = 2;
                procName = "InsertRecord";
                long key = curKey++;
                String[] fields = insertRecords.get(opNum % insertRecords.size());
                params = new Object[]{ key, fields };
                break;
            case 3:
                procIdx = 3;
                procName = "DeleteRecord";
                params = new Object[] { keys.get(opNum % keys.size()) };
                break;
            default:
                throw new RuntimeException("Unexpected queryType " + queryType);
        } // SWITCH

        opNum++;

        Callback callback = new Callback(procIdx);
        return this.getClientHandle().callProcedure(callback, procName, params);
    }

    private class Callback implements ProcedureCallback {
        private final int idx;

        public Callback(int idx) {
            this.idx = idx;
        }

        @Override
        public void clientCallback(ClientResponse clientResponse) {
            // Increment the BenchmarkComponent's internal counter on the
            // number of transactions that have been completed
            Exception e = clientResponse.getException();
            if (e != null) {
                LOG.error(e.getMessage());
                e.printStackTrace();
            }
            incrementTransactionCounter(clientResponse, this.idx);
        }
    } // END CLASS

    @Override
    public String[] getTransactionDisplayNames() {
        // Return an array of transaction names
        String procNames[] = new String[ConvivaProjectBuilder.PROCEDURES.length];
        for (int i = 0; i < procNames.length; i++) {
            procNames[i] = ConvivaProjectBuilder.PROCEDURES[i].getSimpleName();
        }
        return (procNames);
    }
}
