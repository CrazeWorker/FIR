package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.beans.PropertyVetoException;

/**
 * 一个Spring的配置容器，作用相当与applicationContext.xml
 */
@Configuration
@ComponentScan(value = "com")
@Import(JdbcConfig.class)
@PropertySource(value = "classpath:com/config/jdbcConfig.properties")
public class SpringConfiguration {
    @Bean
    public PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
