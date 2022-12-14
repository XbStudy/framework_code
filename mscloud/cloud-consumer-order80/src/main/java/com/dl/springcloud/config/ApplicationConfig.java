package com.dl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    //@LoadBalanced //开启RestTemplate的负载均衡功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
