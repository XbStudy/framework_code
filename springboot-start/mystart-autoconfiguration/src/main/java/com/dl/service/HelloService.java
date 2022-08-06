package com.dl.service;

import com.dl.properties.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String hello(String name){
        return helloProperties.getPrefix() + name + helloProperties.getSuffix();
    }

}
