package com.dl.controller;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    //RestFul是一种风格
    //根据请求的方式来处理……

    //原来的方式,前端：/add?a=1&b=2
    @RequestMapping("/add1")
    public String fun1(int a,int b,Model model){ //参数的名字，必须和前端传过来的参数的名字一样
        model.addAttribute("msg","fun1:"+(a+b));
        return "test";
    }

    //RestFul，前端：/add/a/b
    @RequestMapping("/add2/{a}/{b}")
    //使用@PathVariable注解，让方法参数的值对应绑定到一个URI模板变量上
    public String fun2(@PathVariable int a,@PathVariable int b, Model model){ //参数的名字，必须和前端传过来的参数的名字一样
        model.addAttribute("msg","fun2:"+(a+b));
        return "test";
    }

    //RestFul，前端：/add3/a/b
    @RequestMapping(value = "/add3/{a}/{b}",method = RequestMethod.POST)  //只有post方式的请求才能走这个请求路径，否则报错405
    //使用@PathVariable注解，让方法参数的值对应绑定到一个URI模板变量上
    public String fun3(@PathVariable int a,@PathVariable int b, Model model){ //参数的名字，必须和前端传过来的参数的名字一样
        model.addAttribute("msg","fun3:"+(a+b));
        return "test";
    }

    //也可以这么写： @GetMapping @DeleteMapping @PostMapping  @PutMapping @PatchMapping
    @GetMapping("/add4/{a}/{b}")  //只有GET方式的请求才能走这个请求路径，否则报错405
    //使用@PathVariable注解，让方法参数的值对应绑定到一个URI模板变量上
    public String fun4(@PathVariable int a,@PathVariable int b, Model model){ //参数的名字，必须和前端传过来的参数的名字一样
        model.addAttribute("msg","fun4:"+(a+b));
        return "test";
    }

    /*
    如果在方法上同时写了两个注解：
        @GetMapping("/add4/{a}/{b}")
        @PostMapping("/add4/{a}/{b}")
        那么只有第一个生效
     */

}
