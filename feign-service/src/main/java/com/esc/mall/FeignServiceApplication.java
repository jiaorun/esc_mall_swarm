package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Fegin 启动类
 *
 * @author jiaorun
 * @date 2022/1/10 11:12
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignServiceApplication.class, args);
    }
}
