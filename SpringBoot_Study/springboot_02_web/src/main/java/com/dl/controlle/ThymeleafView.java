package com.dl.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafView {

    @RequestMapping("/thymeleaf01")
    public String thymeleaf01(Model model){
        model.addAttribute("msg","小白ok");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }

}
