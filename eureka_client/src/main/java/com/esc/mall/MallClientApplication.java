package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Eureka客户端
 *
 * @author jiaorun
 * @date 2022/1/6 11:07
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MallClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallClientApplication.class, args);
    }
}
