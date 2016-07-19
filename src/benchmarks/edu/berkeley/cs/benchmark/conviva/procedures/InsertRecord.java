package edu.berkeley.cs.benchmark.conviva.procedures;

import org.voltdb.ProcInfo;
import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

@ProcInfo(
    partitionInfo = "CONVIVATABLE.CONVIVA_KEY: 0",
    singlePartition = true
)
public class InsertRecord extends VoltProcedure {

    public final SQLStmt insertStmt = new SQLStmt(
        "INSERT INTO CONVIVATABLE VALUES (" +
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
          "?)"
    );

    public VoltTable[] run(long id, String fields[]) {
        voltQueueSQL(insertStmt,
		        id,
		        fields[0], // FIELD1
            fields[1], // FIELD2
            fields[2], // FIELD3
            fields[3], // FIELD4
            fields[4], // FIELD5
            fields[5], // FIELD6
            fields[6], // FIELD7
            fields[7], // FIELD8
            fields[8], // FIELD9
            fields[9],  // FIELD10
            fields[10], // FIELD11
            fields[11], // FIELD12
            fields[12], // FIELD13
            fields[13], // FIELD14
            fields[14], // FIELD15
            fields[15]  // FIELD16
        );
        return voltExecuteSQL(true);
    }
}
