package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Consul 启动类
 *
 * @author jiaorun
 * @date 2022/1/12 14:39
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulUserServiceApplication.class, args);
    }
}
