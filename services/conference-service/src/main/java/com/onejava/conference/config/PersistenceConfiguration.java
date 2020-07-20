package com.onejava.conference.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
Uncomment @Bean to enable it.
 */
@Configuration
public class PersistenceConfiguration {
    //@Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/conference_app");
        builder.username("postgres");
        builder.password("admin123");
        System.out.println("My Custom Data Source Bean Has Been Initialized And Set");
        return builder.build();
    }
}
