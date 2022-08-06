package com.dl.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/goLogin")
    public String goLogin(HttpServletRequest request){
        return "login";
    }

    @RequestMapping("/goMain")
    public String goMain(){
        return "main";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        //验证……
        //成功--》跳转到首页
        session.setAttribute("loginInfo",username);
        model.addAttribute("username",username);
        return "main";
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession session){
        //注销
        session.removeAttribute("loginInfo");
        return "redirect:/index.jsp";
    }

}
