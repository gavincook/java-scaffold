package com.example.base.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty(name = "spring.liquibase.enabled", havingValue = "true", matchIfMissing = true)
public class LiquibaseConfiguration {
    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:migration/master.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}
