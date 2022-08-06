package com.dl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication(scanBasePackages ="com.dl") 改变默认的包扫描路径
// @ComponentScan("") 改变默认的包扫描路径
@SpringBootApplication
public class SpringbootDemo01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDemo01Application.class, args);
    }

}
