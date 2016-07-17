package edu.berkeley.cs.benchmark.slog;

import edu.brown.api.BenchmarkComponent;
import edu.brown.catalog.CatalogUtil;
import edu.brown.logging.LoggerUtil;
import edu.brown.logging.LoggerUtil.LoggerBoolean;
import org.apache.log4j.Logger;
import org.voltdb.CatalogContext;
import org.voltdb.VoltTable;
import org.voltdb.catalog.Table;
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
public class SLOGClient extends BenchmarkComponent {
    private static final Logger LOG = Logger.getLogger(SLOGClient.class);
    private static final LoggerBoolean debug = new LoggerBoolean();
    static {
        LoggerUtil.attachObserver(LOG, debug);
    }

    public class SearchQuery {
        SearchQuery(int fieldIdx, String param) {
            this.procIdx = fieldIdx;
            this.procName = "SearchField" + fieldIdx;
            this.attributeValue = param;
        }
        public int procIdx;
        public String procName;
        public String attributeValue;
    }

    private int initNumRecords;
    private final ArrayList<Integer> queryTypes;
    private final ArrayList<Long> keys;
    private final ArrayList<SearchQuery> searchQueries;
    private final ArrayList<Object[]> insertRecords;

    private int opNum;
    private int curKey;

    public static void main(String args[]) {
        BenchmarkComponent.main(SLOGClient.class, args, false);
    }

    public SLOGClient(String args[]) {
        super(args);

        String insertsFile = "~/data.inserts";
        String queryFile = "~/data.queries";
        String queryDistribution = "0.34,0.33,0.33,0.00";
        int numRecords = SLOGConstants.NUM_RECORDS;
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

        this.initNumRecords = numRecords;

        String[] dist = queryDistribution.split("\\|");
        double getMark = Double.parseDouble(dist[0]);
        double searchMark = getMark + Double.parseDouble(dist[1]);
        double insertMark = searchMark + Double.parseDouble(dist[2]);
        double deleteMark = insertMark + Double.parseDouble(dist[3]);
        assert (deleteMark == 1.0);

        final CatalogContext catalogContext = this.getCatalogContext();
        final Table catalog_tbl = catalogContext.getTableByName(SLOGConstants.TABLE_NAME);
        VoltTable table = CatalogUtil.getVoltTable(catalog_tbl);
        LOG.info("Number of rows in table: " + table.getRowCount());

        LOG.info("Loading insert records...");
        this.insertRecords = new ArrayList<Object[]>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(insertsFile));
            String valueString;
            int numInsertRecords = 0;
            while (numInsertRecords < SLOGConstants.QUERY_COUNT && (valueString = br.readLine()) != null) {
                Object[] row = new Object[table.getColumnCount()];
                row[0] = 0;
                System.arraycopy(valueString.split("\\|"), 0, row, 1, SLOGConstants.NUM_COLUMNS);
                this.insertRecords.add(row);
                numInsertRecords++;
            }
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
            while (numQueries < SLOGConstants.QUERY_COUNT && (queryString = br.readLine()) != null) {
                String[] queryParams = queryString.split("\t");
                int fieldIdx = Integer.parseInt(queryParams[0]) + 1;
                String attr = queryParams[1];
                this.searchQueries.add(new SearchQuery(fieldIdx, attr));
                numQueries++;
            }
        } catch (IOException e) {
            LOG.error("Could not open file " + queryFile + " : " + e.getMessage(), e);
            System.exit(-1);
        }


        Random randGen = new Random();
        this.queryTypes = new ArrayList<Integer>();
        for (int i = 0; i < SLOGConstants.QUERY_COUNT; i++) {
            final double r = randGen.nextDouble();
            if (r <= getMark) {
                this.queryTypes.add(0);
            } else if (r <= searchMark) {
                this.queryTypes.add(1);
            } else if (r <= insertMark) {
                this.queryTypes.add(2);
            } else if (r <= deleteMark) {
                this.queryTypes.add(3);
            }
        }

        LOG.info("Loading keys...");
        this.keys = new ArrayList<Long>();
        for (int i = 0; i < SLOGConstants.QUERY_COUNT; i++) {
            this.keys.add(randGen.nextLong() % this.initNumRecords);
        }

        this.opNum = 0;
        this.curKey = initNumRecords;
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
        int queryType = queryTypes.get(opNum);
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
                SearchQuery query = searchQueries.get(opNum % searchQueries.size());
                procIdx = query.procIdx;
                procName = query.procName;
                params = new Object[] { query.attributeValue };
                break;
            case 2:
                procIdx = 17;
                procName = "InsertRecord";
                params = insertRecords.get(opNum % insertRecords.size());
                params[0] = curKey++;
                break;
            case 3:
                procIdx = 18;
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
            incrementTransactionCounter(clientResponse, this.idx);

        }
    } // END CLASS

    @Override
    public String[] getTransactionDisplayNames() {
        // Return an array of transaction names
        String procNames[] = new String[SLOGProjectBuilder.PROCEDURES.length];
        for (int i = 0; i < procNames.length; i++) {
            procNames[i] = SLOGProjectBuilder.PROCEDURES[i].getSimpleName();
        }
        return (procNames);
    }
}
