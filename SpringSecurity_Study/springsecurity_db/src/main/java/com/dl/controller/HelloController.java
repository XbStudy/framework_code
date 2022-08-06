package com.dl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Security";
    }

    @RequestMapping("/test01")
    public String test01(){
        return "test01!!! ";
    }

    @RequestMapping("/test02")
    public String test02(){
        return "test02!!! ";
    }

    @RequestMapping("/success")
    public String success(){
        return "Success!!! ";
    }


}
