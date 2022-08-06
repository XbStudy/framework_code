package com.dl.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/goto")
    public String gotoPage(Model model) {
        model.addAttribute("msg","转法的信息");
        return "forward:/success";
    }

    @RequestMapping("/success")
    @ResponseBody
    public String success(@RequestAttribute("msg") String msg) {
        System.out.println(msg);
        return msg;
    }

}
