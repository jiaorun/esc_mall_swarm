package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Nacos config 启动类
 *
 * @author jiaorun
 * @date 2022/1/25 12:19
 **/
@SpringBootApplication
public class NacosConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientApplication.class, args);
    }
}
