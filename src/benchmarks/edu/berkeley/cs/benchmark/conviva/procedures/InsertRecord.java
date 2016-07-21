package edu.berkeley.cs.benchmark.conviva.procedures;

import org.voltdb.ProcInfo;
import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

@ProcInfo(
  partitionInfo = "CONVIVATABLE.CONVIVA_KEY: 0",
  singlePartition = true) public class InsertRecord extends VoltProcedure {

  public final SQLStmt insertStmt = new SQLStmt("INSERT INTO CONVIVATABLE VALUES (" +
    "?," +  // ID
    "?," +  // FIELD1
    "?," +  // FIELD2
    "?," +  // FIELD3
    "?," +  // FIELD4
    "?," +  // FIELD5
    "?," +  // FIELD6
    "?," +  // FIELD7
    "?," +  // FIELD8
    "?," +  // FIELD9
    "?," +  // FIELD10
    "?," +  // FIELD11
    "?," +  // FIELD12
    "?," +  // FIELD13
    "?," +  // FIELD14
    "?," +  // FIELD15
    "?," +  // FIELD16
    "?," +  // FIELD17
    "?," +  // FIELD18
    "?," +  // FIELD19
    "?," +  // FIELD20
    "?," +  // FIELD21
    "?," +  // FIELD22
    "?," +  // FIELD23
    "?," +  // FIELD24
    "?," +  // FIELD25
    "?," +  // FIELD26
    "?," +  // FIELD27
    "?," +  // FIELD28
    "?," +  // FIELD29
    "?," +  // FIELD30
    "?," +  // FIELD31
    "?," +  // FIELD32
    "?," +  // FIELD33
    "?," +  // FIELD34
    "?," +  // FIELD35
    "?," +  // FIELD36
    "?," +  // FIELD37
    "?," +  // FIELD38
    "?," +  // FIELD39
    "?," +  // FIELD40
    "?," +  // FIELD41
    "?," +  // FIELD42
    "?," +  // FIELD43
    "?," +  // FIELD44
    "?," +  // FIELD45
    "?," +  // FIELD46
    "?," +  // FIELD47
    "?," +  // FIELD48
    "?," +  // FIELD49
    "?," +  // FIELD50
    "?," +  // FIELD51
    "?," +  // FIELD52
    "?," +  // FIELD53
    "?," +  // FIELD54
    "?," +  // FIELD55
    "?," +  // FIELD56
    "?," +  // FIELD57
    "?," +  // FIELD58
    "?," +  // FIELD59
    "?," +  // FIELD60
    "?," +  // FIELD61
    "?," +  // FIELD62
    "?," +  // FIELD63
    "?," +  // FIELD64
    "?," +  // FIELD65
    "?," +  // FIELD66
    "?," +  // FIELD67
    "?," +  // FIELD68
    "?," +  // FIELD69
    "?," +  // FIELD70
    "?," +  // FIELD71
    "?," +  // FIELD72
    "?," +  // FIELD73
    "?," +  // FIELD74
    "?," +  // FIELD75
    "?," +  // FIELD76
    "?," +  // FIELD77
    "?," +  // FIELD78
    "?," +  // FIELD79
    "?," +  // FIELD80
    "?," +  // FIELD81
    "?," +  // FIELD82
    "?," +  // FIELD83
    "?," +  // FIELD84
    "?," +  // FIELD85
    "?," +  // FIELD86
    "?," +  // FIELD87
    "?," +  // FIELD88
    "?," +  // FIELD89
    "?," +  // FIELD90
    "?," +  // FIELD91
    "?," +  // FIELD92
    "?," +  // FIELD93
    "?," +  // FIELD94
    "?," +  // FIELD95
    "?," +  // FIELD96
    "?," +  // FIELD97
    "?," +  // FIELD98
    "?," +  // FIELD99
    "?," +  // FIELD100
    "?," +  // FIELD101
    "?," +  // FIELD102
    "?," +  // FIELD103
    "?)");

  public VoltTable[] run(long id, String fields[]) {
    voltQueueSQL(insertStmt, id,
      fields[0], // FIELD1
      fields[1], // FIELD2
      fields[2], // FIELD3
      fields[3], // FIELD4
      fields[4], // FIELD5
      fields[5], // FIELD6
      fields[6], // FIELD7
      fields[7], // FIELD8
      fields[8], // FIELD9
      fields[9], // FIELD10
      fields[10], // FIELD11
      fields[11], // FIELD12
      fields[12], // FIELD13
      fields[13], // FIELD14
      fields[14], // FIELD15
      fields[15], // FIELD16
      fields[16], // FIELD17
      fields[17], // FIELD18
      fields[18], // FIELD19
      fields[19], // FIELD20
      fields[20], // FIELD21
      fields[21], // FIELD22
      fields[22], // FIELD23
      fields[23], // FIELD24
      fields[24], // FIELD25
      fields[25], // FIELD26
      fields[26], // FIELD27
      fields[27], // FIELD28
      fields[28], // FIELD29
      fields[29], // FIELD30
      fields[30], // FIELD31
      fields[31], // FIELD32
      fields[32], // FIELD33
      fields[33], // FIELD34
      fields[34], // FIELD35
      fields[35], // FIELD36
      fields[36], // FIELD37
      fields[37], // FIELD38
      fields[38], // FIELD39
      fields[39], // FIELD40
      fields[40], // FIELD41
      fields[41], // FIELD42
      fields[42], // FIELD43
      fields[43], // FIELD44
      fields[44], // FIELD45
      fields[45], // FIELD46
      fields[46], // FIELD47
      fields[47], // FIELD48
      fields[48], // FIELD49
      fields[49], // FIELD50
      fields[50], // FIELD51
      fields[51], // FIELD52
      fields[52], // FIELD53
      fields[53], // FIELD54
      fields[54], // FIELD55
      fields[55], // FIELD56
      fields[56], // FIELD57
      fields[57], // FIELD58
      fields[58], // FIELD59
      fields[59], // FIELD60
      fields[60], // FIELD61
      fields[61], // FIELD62
      fields[62], // FIELD63
      fields[63], // FIELD64
      fields[64], // FIELD65
      fields[65], // FIELD66
      fields[66], // FIELD67
      fields[67], // FIELD68
      fields[68], // FIELD69
      fields[69], // FIELD70
      fields[70], // FIELD71
      fields[71], // FIELD72
      fields[72], // FIELD73
      fields[73], // FIELD74
      fields[74], // FIELD75
      fields[75], // FIELD76
      fields[76], // FIELD77
      fields[77], // FIELD78
      fields[78], // FIELD79
      fields[79], // FIELD80
      fields[80], // FIELD81
      fields[81], // FIELD82
      fields[82], // FIELD83
      fields[83], // FIELD84
      fields[84], // FIELD85
      fields[85], // FIELD86
      fields[86], // FIELD87
      fields[87], // FIELD88
      fields[88], // FIELD89
      fields[89], // FIELD90
      fields[90], // FIELD91
      fields[91], // FIELD92
      fields[92], // FIELD93
      fields[93], // FIELD94
      fields[94], // FIELD95
      fields[95], // FIELD96
      fields[96], // FIELD97
      fields[97], // FIELD98
      fields[98], // FIELD99
      fields[99], // FIELD100
      fields[100], // FIELD101
      fields[101], // FIELD102
      fields[102], // FIELD103
      fields[103]); // FIELD104

    return voltExecuteSQL(true);
  }
}
