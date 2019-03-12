package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class JdbcConfig {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;


    //    配置C3P0
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(@Qualifier("ds2")DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "ds2")
    public DataSource createDataSource(){
        System.out.println(driver);
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(user);
            dataSource.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "ds")
        public DataSource createDataSource1(){
            System.out.println(url);
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            try {
                dataSource.setDriverClass(driver);
                dataSource.setJdbcUrl(url);
                dataSource.setUser(user);
                dataSource.setPassword(password);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
            return dataSource;
        }
}
