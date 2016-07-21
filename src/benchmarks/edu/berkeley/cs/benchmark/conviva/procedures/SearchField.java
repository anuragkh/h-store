package edu.berkeley.cs.benchmark.conviva.procedures;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class SearchField extends VoltProcedure {

  public final SQLStmt searchStmt1 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD1 = ?");
  public final SQLStmt searchStmt2 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD2 = ?");
  public final SQLStmt searchStmt3 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD3 = ?");
  public final SQLStmt searchStmt4 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD4 = ?");
  public final SQLStmt searchStmt5 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD5 = ?");
  public final SQLStmt searchStmt6 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD6 = ?");
  public final SQLStmt searchStmt7 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD7 = ?");
  public final SQLStmt searchStmt8 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD8 = ?");
  public final SQLStmt searchStmt9 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD9 = ?");
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
  public final SQLStmt searchStmt20 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD20 = ?");
  public final SQLStmt searchStmt21 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD21 = ?");
  public final SQLStmt searchStmt22 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD22 = ?");
  public final SQLStmt searchStmt23 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD23 = ?");
  public final SQLStmt searchStmt24 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD24 = ?");
  public final SQLStmt searchStmt25 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD25 = ?");
  public final SQLStmt searchStmt26 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD26 = ?");
  public final SQLStmt searchStmt27 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD27 = ?");
  public final SQLStmt searchStmt28 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD28 = ?");
  public final SQLStmt searchStmt29 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD29 = ?");
  public final SQLStmt searchStmt30 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD30 = ?");
  public final SQLStmt searchStmt31 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD31 = ?");
  public final SQLStmt searchStmt32 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD32 = ?");
  public final SQLStmt searchStmt33 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD33 = ?");
  public final SQLStmt searchStmt34 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD34 = ?");
  public final SQLStmt searchStmt35 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD35 = ?");
  public final SQLStmt searchStmt36 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD36 = ?");
  public final SQLStmt searchStmt37 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD37 = ?");
  public final SQLStmt searchStmt38 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD38 = ?");
  public final SQLStmt searchStmt39 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD39 = ?");
  public final SQLStmt searchStmt40 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD40 = ?");
  public final SQLStmt searchStmt41 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD41 = ?");
  public final SQLStmt searchStmt42 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD42 = ?");
  public final SQLStmt searchStmt43 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD43 = ?");
  public final SQLStmt searchStmt44 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD44 = ?");
  public final SQLStmt searchStmt45 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD45 = ?");
  public final SQLStmt searchStmt46 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD46 = ?");
  public final SQLStmt searchStmt47 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD47 = ?");
  public final SQLStmt searchStmt48 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD48 = ?");
  public final SQLStmt searchStmt49 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD49 = ?");
  public final SQLStmt searchStmt50 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD50 = ?");
  public final SQLStmt searchStmt51 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD51 = ?");
  public final SQLStmt searchStmt52 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD52 = ?");
  public final SQLStmt searchStmt53 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD53 = ?");
  public final SQLStmt searchStmt54 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD54 = ?");
  public final SQLStmt searchStmt55 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD55 = ?");
  public final SQLStmt searchStmt56 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD56 = ?");
  public final SQLStmt searchStmt57 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD57 = ?");
  public final SQLStmt searchStmt58 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD58 = ?");
  public final SQLStmt searchStmt59 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD59 = ?");
  public final SQLStmt searchStmt60 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD60 = ?");
  public final SQLStmt searchStmt61 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD61 = ?");
  public final SQLStmt searchStmt62 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD62 = ?");
  public final SQLStmt searchStmt63 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD63 = ?");
  public final SQLStmt searchStmt64 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD64 = ?");
  public final SQLStmt searchStmt65 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD65 = ?");
  public final SQLStmt searchStmt66 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD66 = ?");
  public final SQLStmt searchStmt67 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD67 = ?");
  public final SQLStmt searchStmt68 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD68 = ?");
  public final SQLStmt searchStmt69 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD69 = ?");
  public final SQLStmt searchStmt70 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD70 = ?");
  public final SQLStmt searchStmt71 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD71 = ?");
  public final SQLStmt searchStmt72 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD72 = ?");
  public final SQLStmt searchStmt73 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD73 = ?");
  public final SQLStmt searchStmt74 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD74 = ?");
  public final SQLStmt searchStmt75 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD75 = ?");
  public final SQLStmt searchStmt76 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD76 = ?");
  public final SQLStmt searchStmt77 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD77 = ?");
  public final SQLStmt searchStmt78 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD78 = ?");
  public final SQLStmt searchStmt79 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD79 = ?");
  public final SQLStmt searchStmt80 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD80 = ?");
  public final SQLStmt searchStmt81 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD81 = ?");
  public final SQLStmt searchStmt82 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD82 = ?");
  public final SQLStmt searchStmt83 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD83 = ?");
  public final SQLStmt searchStmt84 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD84 = ?");
  public final SQLStmt searchStmt85 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD85 = ?");
  public final SQLStmt searchStmt86 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD86 = ?");
  public final SQLStmt searchStmt87 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD87 = ?");
  public final SQLStmt searchStmt88 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD88 = ?");
  public final SQLStmt searchStmt89 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD89 = ?");
  public final SQLStmt searchStmt90 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD90 = ?");
  public final SQLStmt searchStmt91 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD91 = ?");
  public final SQLStmt searchStmt92 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD92 = ?");
  public final SQLStmt searchStmt93 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD93 = ?");
  public final SQLStmt searchStmt94 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD94 = ?");
  public final SQLStmt searchStmt95 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD95 = ?");
  public final SQLStmt searchStmt96 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD96 = ?");
  public final SQLStmt searchStmt97 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD97 = ?");
  public final SQLStmt searchStmt98 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD98 = ?");
  public final SQLStmt searchStmt99 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD99 = ?");
  public final SQLStmt searchStmt100 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD100 = ?");
  public final SQLStmt searchStmt101 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD101 = ?");
  public final SQLStmt searchStmt102 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD102 = ?");
  public final SQLStmt searchStmt103 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD103 = ?");
  public final SQLStmt searchStmt104 = new SQLStmt("SELECT * FROM CONVIVATABLE WHERE FIELD104 = ?");

  public VoltTable[] run(int attrId, String value) {

    switch (attrId) {
      case 1:
        voltQueueSQL(searchStmt1, value);
        break;
      case 2:
        voltQueueSQL(searchStmt2, value);
        break;
      case 3:
        voltQueueSQL(searchStmt3, value);
        break;
      case 4:
        voltQueueSQL(searchStmt4, value);
        break;
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
      case 9:
        voltQueueSQL(searchStmt9, value);
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
      case 20:
        voltQueueSQL(searchStmt20, value);
        break;
      case 21:
        voltQueueSQL(searchStmt21, value);
        break;
      case 22:
        voltQueueSQL(searchStmt22, value);
        break;
      case 23:
        voltQueueSQL(searchStmt23, value);
        break;
      case 24:
        voltQueueSQL(searchStmt24, value);
        break;
      case 25:
        voltQueueSQL(searchStmt25, value);
        break;
      case 26:
        voltQueueSQL(searchStmt26, value);
        break;
      case 27:
        voltQueueSQL(searchStmt27, value);
        break;
      case 28:
        voltQueueSQL(searchStmt28, value);
        break;
      case 29:
        voltQueueSQL(searchStmt29, value);
        break;
      case 30:
        voltQueueSQL(searchStmt30, value);
        break;
      case 31:
        voltQueueSQL(searchStmt31, value);
        break;
      case 32:
        voltQueueSQL(searchStmt32, value);
        break;
      case 33:
        voltQueueSQL(searchStmt33, value);
        break;
      case 34:
        voltQueueSQL(searchStmt34, value);
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
      case 41:
        voltQueueSQL(searchStmt41, value);
        break;
      case 42:
        voltQueueSQL(searchStmt42, value);
        break;
      case 43:
        voltQueueSQL(searchStmt43, value);
        break;
      case 44:
        voltQueueSQL(searchStmt44, value);
        break;
      case 45:
        voltQueueSQL(searchStmt45, value);
        break;
      case 46:
        voltQueueSQL(searchStmt46, value);
        break;
      case 47:
        voltQueueSQL(searchStmt47, value);
        break;
      case 48:
        voltQueueSQL(searchStmt48, value);
        break;
      case 49:
        voltQueueSQL(searchStmt49, value);
        break;
      case 50:
        voltQueueSQL(searchStmt50, value);
        break;
      case 51:
        voltQueueSQL(searchStmt51, value);
        break;
      case 52:
        voltQueueSQL(searchStmt52, value);
        break;
      case 53:
        voltQueueSQL(searchStmt53, value);
        break;
      case 54:
        voltQueueSQL(searchStmt54, value);
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
      case 60:
        voltQueueSQL(searchStmt60, value);
        break;
      case 61:
        voltQueueSQL(searchStmt61, value);
        break;
      case 62:
        voltQueueSQL(searchStmt62, value);
        break;
      case 63:
        voltQueueSQL(searchStmt63, value);
        break;
      case 64:
        voltQueueSQL(searchStmt64, value);
        break;
      case 65:
        voltQueueSQL(searchStmt65, value);
        break;
      case 66:
        voltQueueSQL(searchStmt66, value);
        break;
      case 67:
        voltQueueSQL(searchStmt67, value);
        break;
      case 68:
        voltQueueSQL(searchStmt68, value);
        break;
      case 69:
        voltQueueSQL(searchStmt69, value);
        break;
      case 70:
        voltQueueSQL(searchStmt70, value);
        break;
      case 71:
        voltQueueSQL(searchStmt71, value);
        break;
      case 72:
        voltQueueSQL(searchStmt72, value);
        break;
      case 73:
        voltQueueSQL(searchStmt73, value);
        break;
      case 74:
        voltQueueSQL(searchStmt74, value);
        break;
      case 75:
        voltQueueSQL(searchStmt75, value);
        break;
      case 76:
        voltQueueSQL(searchStmt76, value);
        break;
      case 77:
        voltQueueSQL(searchStmt77, value);
        break;
      case 78:
        voltQueueSQL(searchStmt78, value);
        break;
      case 79:
        voltQueueSQL(searchStmt79, value);
        break;
      case 80:
        voltQueueSQL(searchStmt80, value);
        break;
      case 81:
        voltQueueSQL(searchStmt81, value);
        break;
      case 82:
        voltQueueSQL(searchStmt82, value);
        break;
      case 83:
        voltQueueSQL(searchStmt83, value);
        break;
      case 84:
        voltQueueSQL(searchStmt84, value);
        break;
      case 85:
        voltQueueSQL(searchStmt85, value);
        break;
      case 86:
        voltQueueSQL(searchStmt86, value);
        break;
      case 87:
        voltQueueSQL(searchStmt87, value);
        break;
      case 88:
        voltQueueSQL(searchStmt88, value);
        break;
      case 89:
        voltQueueSQL(searchStmt89, value);
        break;
      case 90:
        voltQueueSQL(searchStmt90, value);
        break;
      case 91:
        voltQueueSQL(searchStmt91, value);
        break;
      case 92:
        voltQueueSQL(searchStmt92, value);
        break;
      case 93:
        voltQueueSQL(searchStmt93, value);
        break;
      case 94:
        voltQueueSQL(searchStmt94, value);
        break;
      case 95:
        voltQueueSQL(searchStmt95, value);
        break;
      case 96:
        voltQueueSQL(searchStmt96, value);
        break;
      case 97:
        voltQueueSQL(searchStmt97, value);
        break;
      case 98:
        voltQueueSQL(searchStmt98, value);
        break;
      case 99:
        voltQueueSQL(searchStmt99, value);
        break;
      case 100:
        voltQueueSQL(searchStmt100, value);
        break;
      case 101:
        voltQueueSQL(searchStmt101, value);
        break;
      case 102:
        voltQueueSQL(searchStmt102, value);
        break;
      case 103:
        voltQueueSQL(searchStmt103, value);
        break;
      case 104:
        voltQueueSQL(searchStmt104, value);
        break;
      default:
        assert false : "Invalid attrId " + attrId;
    }

    return (voltExecuteSQL(true));
  }
}
