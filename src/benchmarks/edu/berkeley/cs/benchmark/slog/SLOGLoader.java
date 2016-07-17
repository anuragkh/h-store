package edu.berkeley.cs.benchmark.slog;

import edu.brown.api.BenchmarkComponent;
import edu.brown.api.Loader;
import edu.brown.catalog.CatalogUtil;
import edu.brown.logging.LoggerUtil;
import edu.brown.logging.LoggerUtil.LoggerBoolean;
import org.apache.log4j.Logger;
import org.voltdb.CatalogContext;
import org.voltdb.VoltTable;
import org.voltdb.catalog.Table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * SLOG Database Loader
 * @author anuragk
 */
public class SLOGLoader extends Loader {
    private static final Logger LOG = Logger.getLogger(SLOGClient.class);
    private static final LoggerBoolean debug = new LoggerBoolean();
    static {
        LoggerUtil.attachObserver(LOG, debug);
    }

    private final int initNumRecords;
    private final String dataFile;

    public static void main(String args[]) throws Exception {
        if (debug.val)
            LOG.debug("MAIN: " + SLOGLoader.class.getName());
        BenchmarkComponent.main(SLOGLoader.class, args, true);
    }

    public SLOGLoader(String[] args) {
        super(args);
        if (debug.val)
            LOG.debug("CONSTRUCTOR: " + SLOGLoader.class.getName());

        String dataFileString = "~/data";
        int numRecords = SLOGConstants.NUM_RECORDS;
        for (String key : m_extraParams.keySet()) {
            String value = m_extraParams.get(key);

            // Number of records to load
            if (key.equalsIgnoreCase("num_records")) {
                numRecords = Integer.valueOf(value);
            }
            // Data File
            else if (key.equalsIgnoreCase("data_file")) {
                dataFileString = String.valueOf(value);
            }
        } // FOR

        // Figure out the # of records that we need
        this.initNumRecords = numRecords;
        dataFile = dataFileString;
        LOG.info("Loading database with " + initNumRecords + " records from file "  + dataFile + ".");
    }

    @Override
    public void load() {
        if (debug.val)
            LOG.debug("Starting SLOGLoader");

        final CatalogContext catalogContext = this.getCatalogContext();
        final Table catalog_tbl = catalogContext.getTableByName(SLOGConstants.TABLE_NAME);

        int currentKey = 0;

        // Create an empty VoltTable handle and then populate it in batches
        // to be sent to the DBMS
        VoltTable table = CatalogUtil.getVoltTable(catalog_tbl);
        Object row[] = new Object[table.getColumnCount()];
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(dataFile));
        } catch (IOException e) {
            LOG.error("Could not open file " + dataFile + " : " + e.getMessage(), e);
            System.exit(-1);
        }

        String valueStr;
        try {
            while (currentKey < initNumRecords && (valueStr = in.readLine()) != null) {
                row[0] = currentKey++;

                System.arraycopy(valueStr.split("\\|"), 0, row, 1, SLOGConstants.NUM_COLUMNS);
                table.addRow(row);

                // insert this batch of tuples
                if (table.getRowCount() >= SLOGConstants.BATCH_SIZE) {
                    loadVoltTable(SLOGConstants.TABLE_NAME, table);
                    table.clearRowData();
                    if (debug.val)
                        LOG.debug(String.format("Data Loaded: %dB / %dB",
                                  currentKey, initNumRecords));
                }
            } // FOR
        } catch (IOException e) {
            LOG.error("Could not read from file " + dataFile + " : " + e.getMessage(), e);
            System.exit(-1);
        }

        // load remaining records
        if (table.getRowCount() > 0) {
            loadVoltTable(SLOGConstants.TABLE_NAME, table);
            table.clearRowData();
            if (debug.val)
                LOG.debug(String.format("Data Loaded: %dB / %dB",
                        currentKey, initNumRecords));
        }

        if (debug.val)
            LOG.info("Finished loading " + catalog_tbl.getName());
    }
}
