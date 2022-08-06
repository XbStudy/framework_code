package com.dl.utils;

import com.dl.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 这个也会Spring容器托管，注册到容器中，因为它本来就是一个@Component
// @Configuration代表这是一个配置类，就和我们之前看的beans.xml
@Configuration
@ComponentScan("com.dl.pojo") //使用了注解，开启包扫描
@Import(SpringConfig2.class)  //导入另一个配置类
public class SpringConfig {
    // 注册一个bean，就相当于我们之前写的一个bean标签
    // 这个方法的名字，就相当于bean标签中id属性
    // 这个方法的返回值，就相当于bean标签中的class属性
    @Bean // 可以不指定，就是方法名getUser
    public User getUser(){
        return new User(); // 就是返回要注入到bean的对象！
    }
}
