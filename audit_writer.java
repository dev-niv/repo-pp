package com.example.datagenerator.util;

import java.io.FileWriter;
import java.time.LocalDateTime;

public class AuditWriter {

    public static void writeAudit(String size,int rows,int seed,
                                  String snapshotDate,boolean delta,String schemaVersion) throws Exception{

        FileWriter writer = new FileWriter("/output/run_audit.json");

        writer.write("{\n");
        writer.write("\"size\":\""+size+"\",\n");
        writer.write("\"rows_generated\":"+rows+",\n");
        writer.write("\"seed\":"+seed+",\n");
        writer.write("\"snapshot_date\":\""+snapshotDate+"\",\n");
        writer.write("\"delta\":"+delta+",\n");
        writer.write("\"schema_version\":\""+schemaVersion+"\",\n");
        writer.write("\"generated_at\":\""+ LocalDateTime.now() +"\"\n");
        writer.write("}");

        writer.close();
    }
}
