package com.esc.mall.config;

import com.esc.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

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

    @Autowired
    public AuthorizationServerConfig(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                                     UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
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
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")    //配置client_id
                .secret(passwordEncoder.encode("admin123456"))  //配置client_secret
                .accessTokenValiditySeconds(3600)   //配置访问token的有效期
                .refreshTokenValiditySeconds(864000)    //配置刷新token的有效期
                .redirectUris("http://www.baidu.com")   //配置redirect_uri,用于授权成功后跳转
                .scopes("all")  //配置申请的权限范围
                .authorizedGrantTypes("authorization_code", "password"); //配置grant_type,表示授权类型
    }
}
