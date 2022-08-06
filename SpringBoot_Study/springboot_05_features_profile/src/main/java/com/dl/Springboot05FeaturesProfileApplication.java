package com.dl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@SpringBootApplication
public class Springboot05FeaturesProfileApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot05FeaturesProfileApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        // 获取系统(电脑)的环境变量:
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        // 获取系统(电脑)的属性:
        Map<String, Object> systemProperties = environment.getSystemProperties();
        // 输出:
        System.out.println(systemEnvironment);
        System.out.println("================");
        System.out.println(systemProperties);
    }

}
