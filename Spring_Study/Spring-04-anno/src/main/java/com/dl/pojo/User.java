package com.dl.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component 相当于：<bean id="user" class="com.dl.pojo.User" />
@Component("user")
@Scope("singleton")
public class User {

    // @Value("小白") 相当于 <property name="name" value="小白"/>
    @Value("小白")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
