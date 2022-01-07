package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hystrix熔断器
 *
 * @author jiaorun
 * @date 2022/1/7 11:01
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker   //开启Hystrix的短裤器功能
public class HystrixServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixServiceApplication.class, args);
    }
}
