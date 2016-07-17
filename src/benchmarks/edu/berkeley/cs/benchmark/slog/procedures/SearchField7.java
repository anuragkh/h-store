package edu.berkeley.cs.benchmark.slog.procedures;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class SearchField7 extends VoltProcedure {

	public final SQLStmt scanStmt = new SQLStmt("SELECT * FROM SLOGTABLE WHERE FIELD7 = ?");

  public VoltTable[] run(String value) {
    voltQueueSQL(scanStmt, value);
    return (voltExecuteSQL(true));
  }
}
