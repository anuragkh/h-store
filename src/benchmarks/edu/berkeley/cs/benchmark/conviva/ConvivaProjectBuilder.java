package edu.berkeley.cs.benchmark.conviva;

import edu.berkeley.cs.benchmark.conviva.procedures.*;
import edu.brown.api.BenchmarkComponent;
import edu.brown.benchmark.AbstractProjectBuilder;
import org.voltdb.VoltProcedure;

public class ConvivaProjectBuilder extends AbstractProjectBuilder {

    // REQUIRED: Retrieved via reflection by BenchmarkController
    public static final Class<? extends BenchmarkComponent> m_clientClass = ConvivaClient.class;

    // REQUIRED: Retrieved via reflection by BenchmarkController
    public static final Class<? extends BenchmarkComponent> m_loaderClass = ConvivaLoader.class;

    // a list of procedures implemented in this benchmark
    @SuppressWarnings("unchecked")
    public static final Class<? extends VoltProcedure> PROCEDURES[] = (Class<? extends VoltProcedure>[]) new Class<?>[] {
      ReadRecord.class,
      SearchField.class,
      InsertRecord.class,
      DeleteRecord.class,
    };

    // a list of tables used in this benchmark with corresponding partitioning keys
    public static final String PARTITIONING[][] = new String[][] {
        { "CONVIVATABLE", "CONVIVA_KEY" }
    };

    public ConvivaProjectBuilder() {
        super("conviva", ConvivaProjectBuilder.class, PROCEDURES, PARTITIONING);
    }
}
