package com.dl.rule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个规则不能放在@ComponentCcan能扫描的包下：
 */
@Configuration
public class MyRule {

    @Bean
    public IRule rule(){
        return new RandomRule(); //切换成其他内置的负载均衡算法：改为随机
    }
}
