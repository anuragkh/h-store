package edu.berkeley.cs.benchmark.slog.procedures;

import org.voltdb.ProcInfo;
import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

@ProcInfo(
    partitionInfo = "SLOGTABLE.SLOG_KEY: 0",
    singlePartition = true
)
public class ReadRecord extends VoltProcedure {

    public final SQLStmt readStmt = new SQLStmt("SELECT * FROM SLOGTABLE WHERE SLOG_KEY=?");

    public VoltTable[] run(long id) {
        voltQueueSQL(readStmt, id);
        return (voltExecuteSQL(true));
    }
}
