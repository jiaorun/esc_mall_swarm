package com.esc.mall.config;

import com.esc.mall.component.JwtTokenEnhancer;
import com.esc.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * 认证配置类
 *
 * @author jiaorun
 * @date 2022/1/21 11:03
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    private UserService userService;

    private JwtAccessTokenConverter jwtAccessTokenConverter;

    private JwtTokenEnhancer jwtTokenEnhancer;

    @Autowired
    //@Qualifier("jwtTokenStore")   //指定令牌的存储策略为JWT
    private TokenStore tokenStore;

    @Autowired
    public AuthorizationServerConfig(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                                     UserService userService, JwtAccessTokenConverter jwtAccessTokenConverter,
                                     JwtTokenEnhancer jwtTokenEnhancer) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtAccessTokenConverter = jwtAccessTokenConverter;
        this.jwtTokenEnhancer = jwtTokenEnhancer;
    }

    /**
     * 使用密码模式时需要配置
     *
     * @author jiaorun
     * @data 2022/1/21 11:10
     * @param endpoints
     * @return void
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer);    //配置JWT的内容增强器
        delegates.add(jwtAccessTokenConverter);
        enhancerChain.setTokenEnhancers(delegates);
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)
                .tokenStore(tokenStore)    //配置令牌的存储策略
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenEnhancer(enhancerChain);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")    //配置client_id
                .secret(passwordEncoder.encode("admin123456"))  //配置client_secret
                .accessTokenValiditySeconds(3600)   //配置访问token的有效期
                .refreshTokenValiditySeconds(864000)    //配置刷新token的有效期
                //.redirectUris("http://www.baidu.com")   //配置redirect_uri,用于授权成功后跳转
                .redirectUris("http://localhost:9501/login")    //单点登录时配置
                .autoApprove(true)  //自动授权配置
                .scopes("all")  //配置申请的权限范围
                .authorizedGrantTypes("authorization_code", "password", "refresh_token"); //配置grant_type,表示授权类型
    }

    /**
     * 获取秘钥需要身份认证，使用单点登录时必须配置
     *
     * @author jiaorun
     * @data 2022/1/25 10:08
     * @param security
     * @return void
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("isAuthenticated()");
    }
}
