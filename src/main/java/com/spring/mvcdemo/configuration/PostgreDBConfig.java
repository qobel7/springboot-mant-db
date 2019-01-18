package com.spring.mvcdemo.configuration;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "posrgreEntityManagerFactory",
        transactionManagerRef = "posgreTransactionManager",
        basePackages = {"com.spring.mvcdemo.repositories.postgre"})
public class PostgreDBConfig {


    @Bean
    @ConfigurationProperties("spring.postgre.datasource")
    public DataSourceProperties postgreDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.configuration")
    public DataSource postgreDataSource(@Qualifier("postgreDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
    @Bean(name = "posrgreEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean posrgreEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("postgreDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.spring.mvcdemo.models")
                .build();
    }

    @Bean(name = "posgreTransactionManager")
    public PlatformTransactionManager posgreTransactionManager(
            @Qualifier("posrgreEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
