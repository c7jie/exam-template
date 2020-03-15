package cn.attachie.exam.config;

import com.alibaba.druid.pool.DruidDataSource;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author attaching
 */
@Configuration
@EnableConfigurationProperties({DruidDataSourceProperties.class})
public class DruidConfig {
    @Autowired
    private DruidDataSourceProperties properties;

    @Bean
    @ConditionalOnBean
    public DataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(properties.getDriverClassName());
        druidDataSource.setUrl(properties.getUrl());
        druidDataSource.setUsername(properties.getUsername());
        druidDataSource.setPassword(properties.getPassword());
        druidDataSource.setInitialSize(properties.getInitialSize());
        druidDataSource.setMinIdle(properties.getMinIdle());
        druidDataSource.setMaxActive(properties.getMaxActive());
        druidDataSource.setMaxWait(properties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(properties.getValidationQuery());
        druidDataSource.setTestWhileIdle(properties.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(properties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(properties.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());

        try {
            druidDataSource.setFilters(properties.getFilters());
            druidDataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return druidDataSource;
    }


    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet(){
        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        bean.addInitParameter("allow","127.0.0.1");
        //登录查看信息的账号密码, 用于登录Druid监控后台
        bean.addInitParameter("loginUsername", "admin");
        bean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据.
        bean.addInitParameter("resetEnable", "true");
        return bean;
    }

    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> filterFilterRegistrationBean(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        bean.setFilter(new WebStatFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return bean;
    }
}
