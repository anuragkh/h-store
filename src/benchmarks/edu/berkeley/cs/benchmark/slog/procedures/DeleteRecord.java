package edu.berkeley.cs.benchmark.slog.procedures;

import org.voltdb.ProcInfo;
import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

@ProcInfo(
    partitionInfo = "SLOGTABLE.SLOG_KEY: 0",
    singlePartition = true
)
public class DeleteRecord extends VoltProcedure {

    public final SQLStmt deleteStmt = new SQLStmt("DELETE FROM SLOGTABLE where SLOG_KEY=?");

    public VoltTable[] run(long id) {
        voltQueueSQL(deleteStmt, id);
        return (voltExecuteSQL(true));
    }
}
