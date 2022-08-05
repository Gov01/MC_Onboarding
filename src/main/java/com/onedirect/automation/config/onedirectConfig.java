package com.onedirect.automation.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "onedirectEntityManagerFactory",transactionManagerRef = "onedirectTransactionManager", basePackages = {
        "com.onedirect.automation.onedirect.repository"})
public class onedirectConfig {

    @Bean(name = "onedirectDataSource")
    @ConfigurationProperties(prefix = "spring.onedirect.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "onedirectEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("onedirectDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.onedirect.automation.onedirect.model").persistenceUnit("onedirectModel").build();
    }


    @Bean(name = "onedirectTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("onedirectEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
