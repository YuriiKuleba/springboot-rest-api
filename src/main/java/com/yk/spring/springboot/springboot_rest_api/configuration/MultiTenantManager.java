package com.yk.spring.springboot.springboot_rest_api.configuration;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import com.yk.spring.springboot.springboot_rest_api.service.DataSourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class MultiTenantManager {

    private static final Logger log = LoggerFactory.getLogger(MultiTenantManager.class);
    private final ThreadLocal<String> currentTenant = new ThreadLocal<>();
    private final Map<Object, Object> tenantDataSources = new ConcurrentHashMap<>();
    private final DataSourceProperties properties;

    @Autowired
    private DataSourceService sourceService;

    private AbstractRoutingDataSource multiTenantDataSource;

    public MultiTenantManager(DataSourceProperties properties) {
        this.properties = properties;
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        multiTenantDataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return currentTenant.get();
            }
        };
        multiTenantDataSource.setTargetDataSources(tenantDataSources);
        multiTenantDataSource.setDefaultTargetDataSource(defaultDataSource());
        multiTenantDataSource.afterPropertiesSet();
        return multiTenantDataSource;
    }

    public void addTenant(String tenantId, String url, String username, String password, String driver) throws SQLException {

        DataSource dataSource = DataSourceBuilder.create()
            .driverClassName(driver)
            .url(url)
            .username(username)
            .password(password)
            .build();

        // Check that new connection is 'live'. If not - throw exception
        try(Connection c = dataSource.getConnection()) {
            tenantDataSources.put(tenantId, dataSource);
            multiTenantDataSource.afterPropertiesSet();
        }
    }

    public void setCurrentTenant(String tenantId) {
        currentTenant.set(tenantId);
    }


    public List<String> getTenantNames() {
        return tenantDataSources.keySet()
            .stream().map(Object::toString)
            .toList();
    }

    private DriverManagerDataSource defaultDataSource() throws SQLException {
        DriverManagerDataSource defaultDataSource = new DriverManagerDataSource();
        defaultDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        defaultDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/data_base_1?useSSL=false&serverTimezone=UTC");
        defaultDataSource.setUser("yurko");
        defaultDataSource.setPassword("yurko");
        return defaultDataSource;
    }


}
