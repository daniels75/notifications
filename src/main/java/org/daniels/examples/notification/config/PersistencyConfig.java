package org.daniels.examples.notification.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = { "org.daniels.examples.notification" },
    excludeFilters = { @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION) })
@EnableJpaRepositories(basePackages = { "org.daniels.examples.notification.repository" })
public class PersistencyConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
            throws ClassNotFoundException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPersistenceUnitName("notificationsPersistenceUnit");
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        return factoryBean;
    }
    
//    @Bean
//    public DataSource createDataSource(){
//    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    	dataSource.setUsername("root");
//    	dataSource.setPassword("wodna33");
//    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//    	dataSource.setUrl("jdbc:mysql://localhost/notifications");
//    	
//    	return dataSource;
//    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(false);
        adapter.setGenerateDdl(false);
        adapter.setDatabase(Database.MYSQL);
        return adapter;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws ClassNotFoundException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
