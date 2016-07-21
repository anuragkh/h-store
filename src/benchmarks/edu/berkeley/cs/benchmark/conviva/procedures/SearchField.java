package edu.berkeley.cs.benchmark.conviva.procedures;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class SearchField extends VoltProcedure {

  public final SQLStmt searchStmt5 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD5 = ?");
  public final SQLStmt searchStmt6 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD6 = ?");
  public final SQLStmt searchStmt7 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD7 = ?");
  public final SQLStmt searchStmt8 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD8 = ?");
  public final SQLStmt searchStmt10 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD10 = ?");
  public final SQLStmt searchStmt11 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD11 = ?");
  public final SQLStmt searchStmt12 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD12 = ?");
  public final SQLStmt searchStmt13 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD13 = ?");
  public final SQLStmt searchStmt14 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD14 = ?");
  public final SQLStmt searchStmt15 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD15 = ?");
  public final SQLStmt searchStmt16 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD16 = ?");
  public final SQLStmt searchStmt17 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD17 = ?");
  public final SQLStmt searchStmt18 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD18 = ?");
  public final SQLStmt searchStmt19 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD19 = ?");
  public final SQLStmt searchStmt21 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD21 = ?");
  public final SQLStmt searchStmt24 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD24 = ?");
  public final SQLStmt searchStmt27 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD27 = ?");
  public final SQLStmt searchStmt31 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD31 = ?");
  public final SQLStmt searchStmt32 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD32 = ?");
  public final SQLStmt searchStmt35 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD35 = ?");
  public final SQLStmt searchStmt36 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD36 = ?");
  public final SQLStmt searchStmt37 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD37 = ?");
  public final SQLStmt searchStmt38 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD38 = ?");
  public final SQLStmt searchStmt39 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD39 = ?");
  public final SQLStmt searchStmt40 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD40 = ?");
  public final SQLStmt searchStmt52 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD52 = ?");
  public final SQLStmt searchStmt55 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD55 = ?");
  public final SQLStmt searchStmt56 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD56 = ?");
  public final SQLStmt searchStmt57 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD57 = ?");
  public final SQLStmt searchStmt58 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD58 = ?");
  public final SQLStmt searchStmt59 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD59 = ?");
  public final SQLStmt searchStmt61 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD61 = ?");
  public final SQLStmt searchStmt64 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD64 = ?");
  public final SQLStmt searchStmt67 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD67 = ?");
  public final SQLStmt searchStmt73 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD73 = ?");
  public final SQLStmt searchStmt74 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD74 = ?");
  public final SQLStmt searchStmt76 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD76 = ?");
  public final SQLStmt searchStmt78 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD78 = ?");
  public final SQLStmt searchStmt82 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD82 = ?");
  public final SQLStmt searchStmt86 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD86 = ?");
  public final SQLStmt searchStmt87 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD87 = ?");
  public final SQLStmt searchStmt92 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD92 = ?");
  public final SQLStmt searchStmt102 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD102 = ?");

  public VoltTable[] run(int attrId, String value) {

    switch (attrId) {
      case 5:
        voltQueueSQL(searchStmt5, value);
        break;
      case 6:
        voltQueueSQL(searchStmt6, value);
        break;
      case 7:
        voltQueueSQL(searchStmt7, value);
        break;
      case 8:
        voltQueueSQL(searchStmt8, value);
        break;
      case 10:
        voltQueueSQL(searchStmt10, value);
        break;
      case 11:
        voltQueueSQL(searchStmt11, value);
        break;
      case 12:
        voltQueueSQL(searchStmt12, value);
        break;
      case 13:
        voltQueueSQL(searchStmt13, value);
        break;
      case 14:
        voltQueueSQL(searchStmt14, value);
        break;
      case 15:
        voltQueueSQL(searchStmt15, value);
        break;
      case 16:
        voltQueueSQL(searchStmt16, value);
        break;
      case 17:
        voltQueueSQL(searchStmt17, value);
        break;
      case 18:
        voltQueueSQL(searchStmt18, value);
        break;
      case 19:
        voltQueueSQL(searchStmt19, value);
        break;
      case 21:
        voltQueueSQL(searchStmt21, value);
        break;
      case 24:
        voltQueueSQL(searchStmt24, value);
        break;
      case 27:
        voltQueueSQL(searchStmt27, value);
        break;
      case 31:
        voltQueueSQL(searchStmt31, value);
        break;
      case 32:
        voltQueueSQL(searchStmt32, value);
        break;
      case 35:
        voltQueueSQL(searchStmt35, value);
        break;
      case 36:
        voltQueueSQL(searchStmt36, value);
        break;
      case 37:
        voltQueueSQL(searchStmt37, value);
        break;
      case 38:
        voltQueueSQL(searchStmt38, value);
        break;
      case 39:
        voltQueueSQL(searchStmt39, value);
        break;
      case 40:
        voltQueueSQL(searchStmt40, value);
        break;
      case 52:
        voltQueueSQL(searchStmt52, value);
        break;
      case 55:
        voltQueueSQL(searchStmt55, value);
        break;
      case 56:
        voltQueueSQL(searchStmt56, value);
        break;
      case 57:
        voltQueueSQL(searchStmt57, value);
        break;
      case 58:
        voltQueueSQL(searchStmt58, value);
        break;
      case 59:
        voltQueueSQL(searchStmt59, value);
        break;
      case 61:
        voltQueueSQL(searchStmt61, value);
        break;
      case 64:
        voltQueueSQL(searchStmt64, value);
        break;
      case 67:
        voltQueueSQL(searchStmt67, value);
        break;
      case 73:
        voltQueueSQL(searchStmt73, value);
        break;
      case 74:
        voltQueueSQL(searchStmt74, value);
        break;
      case 76:
        voltQueueSQL(searchStmt76, value);
        break;
      case 78:
        voltQueueSQL(searchStmt78, value);
        break;
      case 82:
        voltQueueSQL(searchStmt82, value);
        break;
      case 86:
        voltQueueSQL(searchStmt86, value);
        break;
      case 87:
        voltQueueSQL(searchStmt87, value);
        break;
      case 92:
        voltQueueSQL(searchStmt92, value);
        break;
      case 102:
        voltQueueSQL(searchStmt102, value);
        break;
      default:
        assert false : "Invalid attrId " + attrId;
    }

    return (voltExecuteSQL(true));
  }
}
