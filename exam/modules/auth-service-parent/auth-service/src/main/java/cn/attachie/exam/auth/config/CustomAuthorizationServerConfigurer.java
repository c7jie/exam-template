package cn.attachie.exam.auth.config;

import cn.attachie.exam.auth.security.CustomTokenConverter;
import cn.attachie.exam.common.security.core.ClientDetailsServiceImpl;
import cn.attachie.exam.common.security.exception.CustomOauthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * 授权服务器配置
 *
 * @author tangyi
 * @date 2019-03-14 11:40
 */
@Configuration
public class CustomAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    /**
     * redis连接工厂
     */
    private final RedisConnectionFactory redisConnectionFactory;

    /**
     * 数据源
     */
    private final DataSource dataSource;


    @Autowired
    public CustomAuthorizationServerConfigurer(RedisConnectionFactory redisConnectionFactory,
                                               DataSource dataSource) {
        this.redisConnectionFactory = redisConnectionFactory;
        this.dataSource = dataSource;
    }

    /**
     * 将token存储到redis
     *
     * @return TokenStore
     */
    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * token增强，使用非对称加密算法来对Token进行签名
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        //KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(keyProperties.getKeyStore().getLocation(), keyProperties.getKeyStore().getPassword().toCharArray());
        CustomTokenConverter converter = new CustomTokenConverter();

        //converter.setKeyPair(keyStoreKeyFactory.getKeyPair(keyProperties.getKeyStore().getAlias()));
        return converter;
    }

    /**
     * 使用自定义的JdbcClientDetailsService客户端详情服务
     *
     * @return ClientDetailsService
     */
    @Bean
    public ClientDetailsService clientDetails() {
        return new ClientDetailsServiceImpl(dataSource);
    }

    /**
     * 从数据库加载客户端信息
     *
     * @param clients clients
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetails());
    }

    /**
     * 配置TokenStore、Token增强、认证管理器以及异常处理
     *
     * @param endpoints endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                // 将token存储到redis
                .tokenStore(tokenStore())
                // token增强
                .tokenEnhancer(jwtTokenEnhancer())
                // 异常转换
                .exceptionTranslator(webResponseExceptionTranslator());
    }

    /**
     * 配置认证规则，哪些需要认证哪些不需要
     *
     * @param oauthServer oauthServer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer
                .passwordEncoder(new BCryptPasswordEncoder())
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Bean
    @Lazy
    public WebResponseExceptionTranslator<OAuth2Exception> webResponseExceptionTranslator() {
        return new DefaultWebResponseExceptionTranslator() {
            @Override
            public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
                if (e instanceof OAuth2Exception) {
                    OAuth2Exception exception = (OAuth2Exception) e;
                    // 转换返回结果
                    return ResponseEntity.status(exception.getHttpErrorCode()).body(new CustomOauthException(e.getMessage()));
                } else {
                    throw e;
                }
            }
        };
    }
}

