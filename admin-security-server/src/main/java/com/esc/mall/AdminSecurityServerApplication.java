package com.esc.mall;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author jiaorun
 * @date 2022/1/21 10:01
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdminSecurityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminSecurityServerApplication.class, args);
    }
}
