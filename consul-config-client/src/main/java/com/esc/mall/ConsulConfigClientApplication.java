package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Consul 配置中心 启动类
 *
 * @author jiaorun
 * @date 2022/1/12 15:36
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigClientApplication.class, args);
    }
}
