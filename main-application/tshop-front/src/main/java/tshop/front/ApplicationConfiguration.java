package tshop.front;

//import com.tsystems.javaschool.uberbahn.entities.BaseEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("tshop.back.repositories")
@ComponentScan({"tshop"})
public class ApplicationConfiguration {


    @Bean
    public DataSource dataSourceProd() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setUsername("system");
        dataSource.setPassword("admin");
        return dataSource;
    }


    @Bean
    public HibernateJpaVendorAdapter vendorAdapterProd() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.ORACLE);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(false);
        return vendorAdapter;
    }


    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, HibernateJpaVendorAdapter vendorAdapter) {

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("tshop.back.entities");
        factory.setDataSource(dataSource);
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}