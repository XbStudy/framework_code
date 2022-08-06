package com.dl.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 自定义全局Gateway拦截器：
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*******#####进入MyGlobalFilter######****"+new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username==null||"".equals(username)){
            System.out.println("========>>>用户名为null无法访问！！！");
            boolean b = exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            System.out.println(b);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
