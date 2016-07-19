package edu.berkeley.cs.benchmark.conviva.procedures;

import org.voltdb.ProcInfo;
import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

@ProcInfo(
    partitionInfo = "CONVIVATABLE.CONVIVA_KEY: 0",
    singlePartition = true
)
public class ReadRecord extends VoltProcedure {

    public final SQLStmt readStmt = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE CONVIVA_KEY=?");

    public VoltTable[] run(long id) {
        voltQueueSQL(readStmt, id);
        return (voltExecuteSQL(true));
    }
}
