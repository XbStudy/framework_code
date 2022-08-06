package com.dl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestValueController {

    /**
     * 获取配置文件中的值
     */
    @Value("${person.age}")
    int age;

    /**
     * 获取系统环境变量的值
     */
    @Value("${JAVA_HOME}")
    String javaHome;

    /**
     * 获取系统的属性的值:
     */
    @Value("${os.name}")
    String osName;


    @RequestMapping("/value")
    @ResponseBody
    public Map getValue() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age",age);
        map.put("javaHome",javaHome);
        map.put("osName",osName);
        return map;
    }
}
