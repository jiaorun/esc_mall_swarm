package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * admin-client 启动类
 *
 * @author jiaorun
 * @date 2022/1/21 9:39
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class AdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminClientApplication.class, args);
    }
}
