package com.dl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/HelloController") //可以不写，如果写了的话，下面方法的访问路径就要变成 /HelloController/hello
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","HelloSpringMVCAnnotation!!!!");

        return "hello"; //返回结果会被视图解析器处理
    }




}
