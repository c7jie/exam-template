package cn.attachie.exam.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author attaching
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    /* filters */
    private String filters;

    /* connection pool */
    private int initialSize;
    private int maxActive = 100;
    private int minIdle;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
}
