package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ribbon 启动类
 *
 * @author jiaorun
 * @date 2022/1/6 17:28
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonServerApplication.class, args);
    }
}
