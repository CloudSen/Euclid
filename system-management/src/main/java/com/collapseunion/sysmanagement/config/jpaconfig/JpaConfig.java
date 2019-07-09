package com.collapseunion.sysmanagement.config.jpaconfig;

import com.collapseunion.sysmanagement.config.dbconfig.DataSourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;


/**
 * Spring Data JPA 配置
 *
 * @author CloudSen
 */
@Slf4j
@Configuration
@EnableJpaRepositories(
        basePackages = "com.collapseunion.commonapi.repository",
        transactionManagerRef = "jpaTransactionManager"
)
@EnableTransactionManagement
public class JpaConfig {

    static {
        log.info("======> [ INFO ] Loading JPA Configuration...");
    }

    private final DataSourceConfig dataSourceConfig;

    public JpaConfig(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(false);
        factoryBean.setDataSource(dataSourceConfig.getDynamicDataSourceConfig());
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPackagesToScan("com.collapseunion.commonapi.entity");
        return factoryBean;
    }

    @Bean(name = "jpaTransactionManager")
    public PlatformTransactionManager getPlatformTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }
}
