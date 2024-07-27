package com.yk.spring.springboot.springboot_rest_api.provider;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import com.yk.spring.springboot.springboot_rest_api.entity.User;
import com.yk.spring.springboot.springboot_rest_api.model.DataSourceProperties;
import com.yk.spring.springboot.springboot_rest_api.service.DataSourceService;
import jakarta.persistence.EntityManager;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * This class provides Jpa repositories for data bases like: mysql, postgres etc.
 */
@Configuration
public class JpaRepoProvider {

    private List<SimpleJpaRepository<User, Integer>> repositories;

    @Bean
    public List<SimpleJpaRepository<User, Integer>> createSimpleJpaRepositories(Properties properties) {

        repositories = new ArrayList<>();
        List<DataSource> dataSourceList = getDataSourceList();

        for (DataSource dataSource : dataSourceList) {
            final LocalContainerEntityManagerFactoryBean factoryBean
                = getLocalContainerEntityManagerFactoryBean(properties, dataSource);

            EntityManager entityManager = factoryBean.getNativeEntityManagerFactory().createEntityManager();

            SimpleJpaRepository<User, Integer> jpaRepository = new SimpleJpaRepository<>(User.class,
                entityManager);

            repositories.add(jpaRepository);
        }

        return repositories;
    }

    private static LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(Properties hibernateProperties, DataSource dataSource) {
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.yk.spring.springboot.springboot_rest_api.entity");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties);
        factoryBean.setPersistenceUnitName("mytestdomain");
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factoryBean.afterPropertiesSet();
        return factoryBean;
    }

    public List<SimpleJpaRepository<User, Integer>> getRepositories() {
        return repositories;
    }

    private List<DataSource> getDataSourceList() {
        DataSourceService service = new DataSourceService();

        List<DataSourceProperties> properties = service.readObjects();
        List<DataSource> dataSources = new ArrayList<>();

        for (DataSourceProperties sourceProperties : properties) {
            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

            driverManagerDataSource.setJdbcUrl(sourceProperties.getUrl());
            driverManagerDataSource.setUser(sourceProperties.getUsername());
            driverManagerDataSource.setPassword(sourceProperties.getPassword());
            driverManagerDataSource.setDriverClass(sourceProperties.getDriverClassName());

            dataSources.add(driverManagerDataSource);
        }
        return dataSources;
    }
}

