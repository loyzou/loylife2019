package org.loy.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.miemiedev.mybatis.paginator.OffsetLimitInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.time.Duration;

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "loy.jdbc")
public class DataSourceConfig {
    static final String MAPPER_LOCATION = "classpath*:mybatis/**/*.xml";

    private String username;
    private String password;
    private String driverClass;
    private String url;
    private int initSize;
    private int maxActive;

    /***
     * 数据源
     * @return
     */
    @Bean(name="dataSource")
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(url);

        return druidDataSource;
    }

    /***
     * 事务管理
     */

    public DataSourceTransactionManager getTransaction(){
        return new DataSourceTransactionManager(getDataSource());
    }

    /***
     *sqlSessionfactory
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSesssionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //配置扫描文件
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceConfig.MAPPER_LOCATION));
        sqlSessionFactoryBean.setPlugins(new OffsetLimitInterceptor[] {
                getOffsetLimitInterceptor()
        });
        return sqlSessionFactoryBean;
    }

    OffsetLimitInterceptor getOffsetLimitInterceptor() {
        OffsetLimitInterceptor interceptor = new OffsetLimitInterceptor();
        interceptor.setDialectClass("com.github.miemiedev.mybatis.paginator.dialect.MySQLDialect");
        return interceptor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getInitSize() {
        return initSize;
    }

    public void setInitSize(int initSize) {
        this.initSize = initSize;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }
}
