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
@EnableJpaRepositories(entityManagerFactoryRef = "brandUserLicenseEntityManagerFactory",transactionManagerRef = "brandUserLicenseTransactionManager", basePackages = {
        "com.onedirect.automation.embeddedAnalytics.repository"})
public class brandUserLicenseConfig {
    @Bean(name = "brandUserLicenseDataSource")
    @ConfigurationProperties(prefix = "spring.branduserlicense.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "brandUserLicenseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("brandUserLicenseDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.onedirect.automation.embeddedAnalytics.model").persistenceUnit("brandUserLicenseMapModel").build();
    }


    @Bean(name = "brandUserLicenseTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("brandUserLicenseEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

