package org.mael.blog.dao.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.mael.blog.model.NewsEntry;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("org.mael.blog.dao.hibernate")
public class DaoContextConfig {

    @Bean
    @SuppressWarnings("deprecation")
    public SessionFactory sessionFactory() throws Exception {
        return new LocalSessionFactoryBuilder(this.dataSource())
                .addAnnotatedClass(NewsEntry.class)
                .addProperties(hibernateProps()).buildSessionFactory();

    }

    @Bean
    public Properties hibernateProps() throws Exception {

        PropertiesFactoryBean factory = new PropertiesFactoryBean();

        factory.setLocation(new ClassPathResource(
                "META-INF/blog/dao/hibernate.properties"));

        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();

        dataSource.setDriverClass("org.hsqldb.jdbcDriver");
        dataSource.setJdbcUrl("jdbc:hsqldb:file:/tmp/db/testdb;shutdown=true;ifExists=true");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setIdleConnectionTestPeriodInMinutes(2);
        dataSource.setIdleMaxAgeInMinutes(15);
        dataSource.setMaxConnectionsPerPartition(50);
        dataSource.setMinConnectionsPerPartition(5);
        dataSource.setPartitionCount(3);
        dataSource.setAcquireIncrement(5);
        dataSource.setStatementsCacheSize(50);
        dataSource.setReleaseHelperThreads(5);

        return dataSource;
    }

}
