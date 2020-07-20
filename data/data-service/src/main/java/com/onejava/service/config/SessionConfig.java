package com.onejava.service.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
//@PropertySource("{classpath:resources/persistence-multiple-db.properties}")
@EnableJpaRepositories(basePackages = "com.onejava.service.repository.read",
        entityManagerFactoryRef = "sessionEntityManager", transactionManagerRef = "sessionTransactionManager")
public class SessionConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties sessionDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource sessionDataSource() {
        return sessionDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }


    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean sessionEntityManager() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(sessionDataSource());
        entityManager.setPackagesToScan("com.onejava.service.repository.read");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(vendorAdapter);
        return entityManager;
    }

    @Primary
    @Bean
    public PlatformTransactionManager sessionTransactionManager(
            final @Qualifier("sessionEntityManager") LocalContainerEntityManagerFactoryBean sessionEntityManager) {
        return new JpaTransactionManager(sessionEntityManager.getObject());
    }

}
