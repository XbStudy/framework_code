package com.dl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.dl.mapper")
// 开启注解支持：
//@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SpringsecurityDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityDbApplication.class, args);
    }

}
