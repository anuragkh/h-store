package edu.berkeley.cs.benchmark.conviva.procedures;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class SearchField102 extends VoltProcedure {

    public final SQLStmt searchStmt = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD102 = ?");

    public VoltTable[] run(String value) {
        voltQueueSQL(searchStmt, value);
        return (voltExecuteSQL(true));
    }
}
