package edu.brown.designer.partitioners;

import java.io.File;

import org.voltdb.catalog.Database;

import edu.brown.BaseTestCase;
import edu.brown.designer.Designer;
import edu.brown.designer.DesignerHints;
import edu.brown.designer.DesignerInfo;
import edu.brown.mappings.ParameterMappingsSet;
import edu.brown.statistics.WorkloadStatistics;
import edu.brown.utils.ProjectType;
import edu.brown.workload.Workload;
import edu.brown.workload.filters.Filter;
import edu.brown.workload.filters.ProcedureLimitFilter;

public abstract class BasePartitionerTestCase extends BaseTestCase {

    private static final long WORKLOAD_XACT_LIMIT = 1000;
    private static final int NUM_THREADS = 1;
    protected static final int NUM_PARTITIONS = 10;
    protected static final int NUM_INTERVALS = 10;

    // Reading the workload takes a long time, so we only want to do it once
    protected static Workload workload;
    protected static WorkloadStatistics stats;
    protected static ParameterMappingsSet correlations;
    protected static File correlations_file;

    protected Designer designer;
    protected DesignerInfo info;
    protected DesignerHints hints;

    
    @Override
    protected void setUp(ProjectType type, boolean fkeys) throws Exception {
        super.setUp(type, fkeys);
        
        this.addPartitions(NUM_PARTITIONS);

        // Super hack! Walk back the directories and find out workload directory
        if (workload == null) {
            File workload_file = this.getWorkloadFile(type);
            assertNotNull(workload_file);
            assert(workload_file.exists());
            workload = new Workload(catalog);
            Filter filter = new ProcedureLimitFilter(WORKLOAD_XACT_LIMIT);
            ((Workload) workload).load(workload_file.getAbsolutePath(), catalog_db, filter);
            
            File stats_file = this.getStatsFile(type);
            assertNotNull(stats_file);
            assert(stats_file.exists());
            stats = new WorkloadStatistics(catalog_db);
            try {
                stats.load(stats_file.getAbsolutePath(), catalog_db);
            } catch (AssertionError ex) {
                System.err.println("Failed to load " + stats_file.getAbsolutePath());
                throw ex;
            }
            this.applyCatalogCorrelations(type);
            correlations_file = this.getParameterMappingsFile(type);
            assertNotNull(correlations_file);
            assert(correlations_file.exists());
            correlations = new ParameterMappingsSet();
            correlations.load(correlations_file.getAbsolutePath(), catalog_db);
        }
        
        // Setup everything else (that's just how we roll up in this ma)
        this.info = this.generateInfo(catalog_db); 
        this.hints = new DesignerHints();
    }
    
    protected DesignerInfo generateInfo(Database catalog_db) {
        DesignerInfo info = new DesignerInfo(catalog_db, workload);
        info.setStats(stats);
        info.setCorrelations(correlations);
        info.setCorrelationsFile(correlations_file.getAbsolutePath());
        info.setNumThreads(NUM_THREADS);
        info.setNumIntervals(NUM_INTERVALS);
        return (info);
    }
}
