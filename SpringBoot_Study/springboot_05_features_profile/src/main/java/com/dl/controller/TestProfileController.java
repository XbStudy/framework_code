package com.dl.controller;

import com.dl.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestProfileController {

    @Autowired
    @Qualifier("boss") //指定id来装bean
    Person person;

    /**
     * 使用${}来获取配置文件中的值
     */
    //@Value("${person.name}")
    //private String username;

    @RequestMapping("/")
    @ResponseBody
    public String test() {
        //System.out.println(username);
        return person.toString();
    }
}
