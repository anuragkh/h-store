package edu.berkeley.cs.benchmark.slog.procedures;

import edu.berkeley.cs.benchmark.slog.SLOGConstants;
import org.voltdb.ProcInfo;
import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

import java.util.Arrays;

@ProcInfo(
    partitionInfo = "SLOGTABLE.SLOG_KEY: 0",
    singlePartition = true
)
public class InsertRecord extends VoltProcedure {

    public final SQLStmt insertStmt = new SQLStmt(
        "INSERT INTO SLOGTABLE VALUES (" +
            "?," +  // ID
            "?," +  // FIELD1
            "?," +  // FIELD2
            "?," +  // FIELD3
            "?," +  // FIELD4
            "?," +  // FIELD5
            "?," +  // FIELD6
            "?," +  // FIELD7
            "?," +  // FIELD8
            "?," +  // FIELD9
            "?," +  // FIELD10
            "?," +  // FIELD11
            "?," +  // FIELD12
            "?," +  // FIELD13
            "?," +  // FIELD14
            "?," +  // FIELD15
            "?)"    // FIELD16
    );

    public VoltTable[] run(long id, String fields[]) {
        assert(fields.length == SLOGConstants.NUM_COLUMNS);
        System.out.println("Executing insert query: " + insertStmt + " with parameters: (" + id + ", " + Arrays
          .toString(fields) + ")");
		    voltQueueSQL(insertStmt,
		        id,
		        fields[0], // FIELD1
            fields[1], // FIELD2
            fields[2], // FIELD3
            fields[3], // FIELD4
            fields[4], // FIELD5
            fields[5], // FIELD6
            fields[6], // FIELD7
            fields[7], // FIELD8
            fields[8], // FIELD9
            fields[9],  // FIELD10
            fields[10], // FIELD11
            fields[11], // FIELD12
            fields[12], // FIELD13
            fields[13], // FIELD14
            fields[14], // FIELD15
            fields[15]  // FIELD16
        );
        return (voltExecuteSQL(true));
    }
}
