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
@EnableJpaRepositories(entityManagerFactoryRef = "chatviewEntityManagerFactory",transactionManagerRef = "chatviewTransactionManager", basePackages = {
        "com.onedirect.automation.chatview.repository"})
public class chatviewConfig {

    @Bean(name = "chatviewDataSource")
    @ConfigurationProperties(prefix = "spring.chatview.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "chatviewEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("chatviewDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.onedirect.automation.chatview.model").persistenceUnit("chatviewModel").build();
    }



    @Bean(name = "chatviewTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("chatviewEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

