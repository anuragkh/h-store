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
      SearchField17.class,
      SearchField18.class,
      SearchField19.class,
      SearchField20.class,
      SearchField21.class,
      SearchField22.class,
      SearchField23.class,
      SearchField24.class,
      SearchField25.class,
      SearchField26.class,
      SearchField27.class,
      SearchField28.class,
      SearchField29.class,
      SearchField30.class,
      SearchField31.class,
      SearchField32.class,
      SearchField33.class,
      SearchField34.class,
      SearchField35.class,
      SearchField36.class,
      SearchField37.class,
      SearchField38.class,
      SearchField39.class,
      SearchField40.class,
      SearchField41.class,
      SearchField42.class,
      SearchField43.class,
      SearchField44.class,
      SearchField45.class,
      SearchField46.class,
      SearchField47.class,
      SearchField48.class,
      SearchField49.class,
      SearchField50.class,
      SearchField51.class,
      SearchField52.class,
      SearchField53.class,
      SearchField54.class,
      SearchField55.class,
      SearchField56.class,
      SearchField57.class,
      SearchField58.class,
      SearchField59.class,
      SearchField60.class,
      SearchField61.class,
      SearchField62.class,
      SearchField63.class,
      SearchField64.class,
      SearchField65.class,
      SearchField66.class,
      SearchField67.class,
      SearchField68.class,
      SearchField69.class,
      SearchField70.class,
      SearchField71.class,
      SearchField72.class,
      SearchField73.class,
      SearchField74.class,
      SearchField75.class,
      SearchField76.class,
      SearchField77.class,
      SearchField78.class,
      SearchField79.class,
      SearchField80.class,
      SearchField81.class,
      SearchField82.class,
      SearchField83.class,
      SearchField84.class,
      SearchField85.class,
      SearchField86.class,
      SearchField87.class,
      SearchField88.class,
      SearchField89.class,
      SearchField90.class,
      SearchField91.class,
      SearchField92.class,
      SearchField93.class,
      SearchField94.class,
      SearchField95.class,
      SearchField96.class,
      SearchField97.class,
      SearchField98.class,
      SearchField99.class,
      SearchField100.class,
      SearchField101.class,
      SearchField102.class,
      SearchField103.class,
      SearchField104.class,
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
