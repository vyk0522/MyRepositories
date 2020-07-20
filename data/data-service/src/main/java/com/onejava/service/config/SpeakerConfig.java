package com.onejava.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//@Configuration
//@PropertySource("{classpath:resources/persistence-multiple-db.properties}")
//@EnableJpaRepositories(basePackages = "com.onejava.service.repository.write",entityManagerFactoryRef = "speakerEntityManager", transactionManagerRef = "speakerTransactionManager")
public class SpeakerConfig {

    @Bean
    @ConfigurationProperties(prefix="app.datasource")
    public DataSource speakerDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean speakerEntityManager() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(speakerDataSource());
        entityManager.setPackagesToScan("com.onejava.service.repository.write");
        return entityManager;
    }

    @Bean
    public PlatformTransactionManager speakerTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(speakerEntityManager().getObject());
        return transactionManager;
    }
}
