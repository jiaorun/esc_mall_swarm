package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Nacos ribbon启动类
 *
 * @author jiaorun
 * @date 2022/1/25 11:55
 **/
@SpringBootApplication
public class NacosRibbonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosRibbonServiceApplication.class, args);
    }
}
