package edu.berkeley.cs.benchmark.conviva.procedures;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class SearchField41 extends VoltProcedure {

    public final SQLStmt searchStmt = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD41 = ?");

    public VoltTable[] run(String value) {
        voltQueueSQL(searchStmt, value);
        return (voltExecuteSQL(true));
    }
}
