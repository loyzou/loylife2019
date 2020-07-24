/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据库信息配置类
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/24
 */
@Configuration
@ConfigurationProperties("loy.data")
@Data
public class LoyDatasourceConfig {
    private String username;
    private String password;
    private String url;

    /***
     * 创建dataSource对象
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    /**
     * 创建事务对象
     * @param dataSource
     * @return
     */
    @Bean
    DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
