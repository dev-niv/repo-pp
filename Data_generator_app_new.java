package com.example.datagenerator;

import com.example.datagenerator.service.DataGeneratorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataGeneratorApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(DataGeneratorApplication.class, args);

        // Read arguments from docker compose
        String size = args.length > 0 ? args[0] : "S";
        int seed = args.length > 1 ? Integer.parseInt(args[1]) : 123;
        String snapshotDate = args.length > 2 ? args[2] : "2026-02-01";
        boolean delta = args.length > 3 && Boolean.parseBoolean(args[3]);
        String schemaVersion = args.length > 4 ? args[4] : "v1";

        DataGeneratorService service = new DataGeneratorService();

        service.generate(size, seed, snapshotDate, delta, schemaVersion);
    }
}
