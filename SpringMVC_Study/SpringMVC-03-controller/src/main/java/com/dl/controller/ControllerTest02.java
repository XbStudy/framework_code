package com.dl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //代表这个类被spring托管
// 被这个注解标注的类中的方法，如果返回值时String，并且有具体的视图可跳转，那么就会被视图解析器解析；
// 如果没有具体的视图就报404
public class ControllerTest02 {

    @RequestMapping("/test02")
    public String fun(Model model){
        model.addAttribute("msg","ControllerTest02");
        return "test";
    }

    @RequestMapping("/test03")
    public String fun3(Model model){
        model.addAttribute("msg","ControllerTest03");
        return "test";
    }


}
