//package com.yk.spring.springboot.springboot_rest_api.configuration;
//
//import com.mchange.v2.c3p0.DriverManagerDataSource;
//import com.yk.spring.springboot.springboot_rest_api.ApplicationContextProvider;
//import com.yk.spring.springboot.springboot_rest_api.entity.User;
//import com.yk.spring.springboot.springboot_rest_api.model.DataSourceProperties;
//import com.yk.spring.springboot.springboot_rest_api.service.DataSourceService;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//
//import javax.sql.DataSource;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Properties;
//
//import static org.hibernate.cfg.PersistenceSettings.PERSISTENCE_UNIT_NAME;
//
////@Configuration
////@ConfigurationProperties(prefix = "dataSource")
//public class EntityManagerConfig {
//
////    private final List<DataSourceProperties> properties = new ArrayList<>();
//
////    @Bean
////    public List<SimpleJpaRepository<User, Integer>> userDAOList() {
////        List<DataSource> dataSources = getDataSourceList();
////
////        List<SimpleJpaRepository<User, Integer>> repositories = dataSources.stream()
////            .map(dataSource -> {
////                LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean
////                    = new LocalContainerEntityManagerFactoryBean();
//////                HashMap<String, Object> stringObjectHashMap = new HashMap<>();
//////                stringObjectHashMap.put(JP)
////
////
////
////                localContainerEntityManagerFactoryBean.setDataSource(dataSource);
////                Properties properties = new Properties();
////                properties.put("hibernate.hbm2ddl.auto", "create");
////
////                EntityManager entityManager =
////                    localContainerEntityManagerFactoryBean.getNativeEntityManagerFactory().createEntityManager();
//////                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//////                EntityManager entityManager = entityManagerFactory.createEntityManager();
////
////                SimpleJpaRepository<User, Integer> jpaRepository;
////                jpaRepository = new SimpleJpaRepository<>(User.class, entityManager);
////                return jpaRepository;
////
////            }).toList();
////
////        return repositories;
////    }
//
//
//
//    private static List<DataSource> getDataSourceList() {
//        DataSourceService service = new DataSourceService();
//
//        List<DataSourceProperties> properties = service.readMyObjects();
//
//        List<DataSource> dataSources = new ArrayList<>();
//
//        for (DataSourceProperties sourceProperties : properties) {
//            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//
//            driverManagerDataSource.setJdbcUrl(sourceProperties.getUrl());
//            driverManagerDataSource.setUser(sourceProperties.getUsername());
//            driverManagerDataSource.setPassword(sourceProperties.getPassword());
//            driverManagerDataSource.setDriverClass(sourceProperties.getDriverClassName());
//
//            dataSources.add(driverManagerDataSource);
//        }
//        return dataSources;
//    }
//}
