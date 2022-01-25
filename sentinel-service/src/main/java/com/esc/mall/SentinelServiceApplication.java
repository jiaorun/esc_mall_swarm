package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Sentinel 启动类
 *
 * @author jiaorun
 * @date 2022/1/25 14:58
 **/
@SpringBootApplication
@EnableFeignClients
public class SentinelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceApplication.class, args);
    }
}
