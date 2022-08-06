package com.dl.controller;

import com.dl.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello SpringBoot2!!!";
    }

    @RequestMapping("/person")
    @ResponseBody
    public String person(){
        return person.toString();
    }




}
