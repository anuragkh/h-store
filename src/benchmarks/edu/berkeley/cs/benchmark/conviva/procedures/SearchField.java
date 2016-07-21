package edu.berkeley.cs.benchmark.conviva.procedures;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class SearchField extends VoltProcedure {

  public final SQLStmt searchStmt6 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD6 = ?");
  public final SQLStmt searchStmt7 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD7 = ?");
  public final SQLStmt searchStmt8 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD8 = ?");
  public final SQLStmt searchStmt9 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD9 = ?");
  public final SQLStmt searchStmt11 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD11 = ?");
  public final SQLStmt searchStmt12 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD12 = ?");
  public final SQLStmt searchStmt13 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD13 = ?");
  public final SQLStmt searchStmt14 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD14 = ?");
  public final SQLStmt searchStmt15 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD15 = ?");
  public final SQLStmt searchStmt16 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD16 = ?");
  public final SQLStmt searchStmt17 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD17 = ?");
  public final SQLStmt searchStmt18 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD18 = ?");
  public final SQLStmt searchStmt19 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD19 = ?");
  public final SQLStmt searchStmt20 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD20 = ?");
  public final SQLStmt searchStmt22 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD22 = ?");
  public final SQLStmt searchStmt25 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD25 = ?");
  public final SQLStmt searchStmt28 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD28 = ?");
  public final SQLStmt searchStmt32 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD32 = ?");
  public final SQLStmt searchStmt33 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD33 = ?");
  public final SQLStmt searchStmt36 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD36 = ?");
  public final SQLStmt searchStmt37 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD37 = ?");
  public final SQLStmt searchStmt38 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD38 = ?");
  public final SQLStmt searchStmt39 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD39 = ?");
  public final SQLStmt searchStmt40 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD40 = ?");
  public final SQLStmt searchStmt41 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD41 = ?");
  public final SQLStmt searchStmt53 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD53 = ?");
  public final SQLStmt searchStmt56 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD56 = ?");
  public final SQLStmt searchStmt57 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD57 = ?");
  public final SQLStmt searchStmt58 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD58 = ?");
  public final SQLStmt searchStmt59 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD59 = ?");
  public final SQLStmt searchStmt60 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD60 = ?");
  public final SQLStmt searchStmt62 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD62 = ?");
  public final SQLStmt searchStmt65 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD65 = ?");
  public final SQLStmt searchStmt68 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD68 = ?");
  public final SQLStmt searchStmt74 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD74 = ?");
  public final SQLStmt searchStmt75 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD75 = ?");
  public final SQLStmt searchStmt77 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD77 = ?");
  public final SQLStmt searchStmt79 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD79 = ?");
  public final SQLStmt searchStmt83 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD83 = ?");
  public final SQLStmt searchStmt87 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD87 = ?");
  public final SQLStmt searchStmt88 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD88 = ?");
  public final SQLStmt searchStmt93 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD93 = ?");
  public final SQLStmt searchStmt103 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD103 = ?");

  public VoltTable[] run(int attrId, String value) {

    switch (attrId) {
      case 6:
        voltQueueSQL(searchStmt6, value);
        break;
      case 7:
        voltQueueSQL(searchStmt7, value);
        break;
      case 8:
        voltQueueSQL(searchStmt8, value);
        break;
      case 9:
        voltQueueSQL(searchStmt9, value);
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
      case 20:
        voltQueueSQL(searchStmt20, value);
        break;
      case 22:
        voltQueueSQL(searchStmt22, value);
        break;
      case 25:
        voltQueueSQL(searchStmt25, value);
        break;
      case 28:
        voltQueueSQL(searchStmt28, value);
        break;
      case 32:
        voltQueueSQL(searchStmt32, value);
        break;
      case 33:
        voltQueueSQL(searchStmt33, value);
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
      case 41:
        voltQueueSQL(searchStmt41, value);
        break;
      case 53:
        voltQueueSQL(searchStmt53, value);
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
      case 60:
        voltQueueSQL(searchStmt60, value);
        break;
      case 62:
        voltQueueSQL(searchStmt62, value);
        break;
      case 65:
        voltQueueSQL(searchStmt65, value);
        break;
      case 68:
        voltQueueSQL(searchStmt68, value);
        break;
      case 74:
        voltQueueSQL(searchStmt74, value);
        break;
      case 75:
        voltQueueSQL(searchStmt75, value);
        break;
      case 77:
        voltQueueSQL(searchStmt77, value);
        break;
      case 79:
        voltQueueSQL(searchStmt79, value);
        break;
      case 83:
        voltQueueSQL(searchStmt83, value);
        break;
      case 87:
        voltQueueSQL(searchStmt87, value);
        break;
      case 88:
        voltQueueSQL(searchStmt88, value);
        break;
      case 93:
        voltQueueSQL(searchStmt93, value);
        break;
      case 103:
        voltQueueSQL(searchStmt103, value);
        break;
      default:
        assert false : "Invalid attrId " + attrId;
    }

    return (voltExecuteSQL(true));
  }
}
