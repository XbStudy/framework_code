package com.dl.admin.config;

import com.dl.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 属于定制化SpringMvc
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 配置拦截器：
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/index","/login","/css/**",
                        "/fonts/**","/images/**","/js/**");
    }




}

