package edu.berkeley.cs.benchmark.slog.procedures;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class SearchField3 extends VoltProcedure {

	public final SQLStmt scanStmt = new SQLStmt("SELECT * FROM SLOGTABLE WHERE FIELD3 = ?");

    public VoltTable[] run(long start, long count) {
        voltQueueSQL(scanStmt, start, start+count);
        return (voltExecuteSQL(true));
    }
}