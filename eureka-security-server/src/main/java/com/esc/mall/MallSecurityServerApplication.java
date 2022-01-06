package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 认证中心
 *
 * @author jiaorun
 * @date 2022/1/6 14:37
 **/
@SpringBootApplication
@EnableEurekaServer
public class MallSecurityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSecurityServerApplication.class, args);;
    }
}
