package com.dl.controller;

import com.dl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//处理请求参数，以及数据回显：
@Controller
public class RequestParamTest01 {

//处理请求参数：
    //情况一：提交的域名称和处理方法的参数名一致：
    @RequestMapping("/t1")
    public String fun1(String a,String b,Model model){
        model.addAttribute("msg","fun1:"+a+b);
        return "test";
    }

    //情况二：提交的域名称和处理方法的参数名不一致：
    // @RequestParam("a") : a=提交的域名称（前端提交的参数名称）
    @RequestMapping("/t2")
    public String fun2(@RequestParam("a") String aa,@RequestParam("b") String bb, Model model){
        model.addAttribute("msg","fun2:"+aa+bb);
        return "test";
    }

    //情况三：提交的是一个对象：要求提交的表单域和对象的属性一致，方法参数使用对象即可
    // localhost:8080/t3?id=xx&name=xx&age=xx
    /*
        1.接收前端的参数，判断参数的名字，假设参数名字与方法的参数名字一样，那么直接使用
        2.假设传递的是多个参数，方法接收的是一个对象，去匹配参数是否与对象的属性是否一致，一致则封装进接收的实体类中，不一致则为接收不到
     */
    @RequestMapping("/t3")
    public String fun3(User user,Model model){
        System.out.println(user);
        model.addAttribute("msg","fun3:"+user);
        return "test";
    }

//数据回显：
    //ModelMap继承了LinkedHashMap；
    // Model的实现类也间接继承了ModelMap；Model是一个精简版，大部分情况使用这个；
    //ModelAndView:可以在存储数据的同时，可以设置返回的逻辑视图，进行控制展示层的跳转

    //ModelAndView
    @RequestMapping("/v1")
    public String test1(ModelAndView mv){
        mv.addObject("msg","ModelAndView:");
        mv.setViewName("test");
        return "test";
    }

    //Model
    @RequestMapping("/v2")
    public String test2(Model model){
        model.addAttribute("msg","Model");
        return "test";
    }

    //ModelMap
    @RequestMapping("/v3")
    public String test3(ModelMap modelMap){
        modelMap.addAttribute("msg","ModelMap");
        return "test";
    }

}



