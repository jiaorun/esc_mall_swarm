package com.esc.mall;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka服务端
 *
 * @author jiaorun
 * @date 2022/1/6 10:45
 **/
@SpringBootApplication
@EnableEurekaServer
public class MallServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServerApplication.class, args);
    }
}
