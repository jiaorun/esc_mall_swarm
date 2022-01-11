package com.esc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 安全认证 启动类
 *
 * @author jiaorun
 * @date 2022/1/11 14:42
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigSecurityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigSecurityServerApplication.class, args);
    }
}
