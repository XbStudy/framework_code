package com.dl;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类上添加@EnableAdminServer注解,开启服务监控的功能
 */
@EnableAdminServer
@SpringBootApplication
public class Springboot04AdminserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04AdminserverApplication.class, args);
    }

}
