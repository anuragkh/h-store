package edu.berkeley.cs.benchmark.conviva.procedures;

import org.voltdb.ProcInfo;
import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

@ProcInfo(
    partitionInfo = "CONVIVATABLE.CONVIVA_KEY: 0",
    singlePartition = true
)
public class DeleteRecord extends VoltProcedure {

    public final SQLStmt deleteStmt = new SQLStmt("DELETE FROM CONVIVATABLE where CONVIVA_KEY=?");

    public VoltTable[] run(long id) {
        voltQueueSQL(deleteStmt, id);
        return (voltExecuteSQL(true));
    }
}
