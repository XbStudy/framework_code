package com.dl.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

     /** 通过写配置类的方式配置：
      * 配置了一个id为baidu_news_guoji的路由规则，
     * 当访问地址 http://localhost:9527/guoji时会自动转发到地址：http://news.baidu.com/guoji
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("baidu_news_guoji",
                r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }


}
