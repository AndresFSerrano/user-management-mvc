package com.jwtspringboot.mvc.usermanagementmvc.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final Environment environment;

    public DataSourceConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    @Profile("dev")
    public DataSource dataSourceDev() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.h2.Driver");
        config.setJdbcUrl("jdbc:h2:mem:test");
        config.setUsername("sa");
        config.setPassword("");
        return new HikariDataSource(config);
    }

    @Bean
    @Profile("prod")
    public DataSource dataSourceProd() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl(environment.getProperty("DB_URL"));
        config.setUsername(environment.getProperty("DB_USERNAME"));
        config.setPassword(environment.getProperty("DB_PASSWORD"));
        return new HikariDataSource(config);
    }
}