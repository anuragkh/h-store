package edu.berkeley.cs.benchmark.slog;

import edu.berkeley.cs.benchmark.slog.procedures.*;
import edu.brown.api.BenchmarkComponent;
import edu.brown.benchmark.AbstractProjectBuilder;
import org.voltdb.VoltProcedure;

public class SLOGProjectBuilder extends AbstractProjectBuilder {

    // REQUIRED: Retrieved via reflection by BenchmarkController
    public static final Class<? extends BenchmarkComponent> m_clientClass = SLOGClient.class;

    // REQUIRED: Retrieved via reflection by BenchmarkController
    public static final Class<? extends BenchmarkComponent> m_loaderClass = SLOGLoader.class;

    // a list of procedures implemented in this benchmark
    @SuppressWarnings("unchecked")
    public static final Class<? extends VoltProcedure> PROCEDURES[] = (Class<? extends VoltProcedure>[]) new Class<?>[] {
        ReadRecord.class,
        SearchField1.class,
        SearchField2.class,
        SearchField3.class,
        SearchField4.class,
        SearchField5.class,
        SearchField6.class,
        SearchField7.class,
        SearchField8.class,
        SearchField9.class,
        SearchField10.class,
        SearchField11.class,
        SearchField12.class,
        SearchField13.class,
        SearchField14.class,
        SearchField15.class,
        SearchField16.class,
        InsertRecord.class,
        DeleteRecord.class,
    };

    // a list of tables used in this benchmark with corresponding partitioning keys
    public static final String PARTITIONING[][] = new String[][] {
        { "SLOGTABLE", "SLOG_KEY" }
    };

    public SLOGProjectBuilder() {
        super("slog", SLOGProjectBuilder.class, PROCEDURES, PARTITIONING);
    }
}
