package com.nepalaya.up.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseSeederConfig {

    public DatabaseSeederConfig(DataSource dataSource) {
        Flyway
                .configure()
                .baselineOnMigrate(true)
                .dataSource(dataSource)
                .load()
                .migrate();
    }
}
