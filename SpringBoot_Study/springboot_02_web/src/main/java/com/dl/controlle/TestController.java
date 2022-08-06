package com.dl.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    // 一个请求会进入先找对应的Controller，没有找到就去静态资源目录下找，没有找到就404
    @ResponseBody
    // @RequestMapping("/tt/aaa.jpg")
    @RequestMapping("/aaa")
    public String t(){
        return "aaa";
    }


}
