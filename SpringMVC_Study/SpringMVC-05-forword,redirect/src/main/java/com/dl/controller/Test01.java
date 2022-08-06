package com.dl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class Test01 {

    //通过ServletAPI实现转发和重定向，不需要视图解析器：
    @RequestMapping("/test/t1")
    public void fun1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession().getId());
        request.setAttribute("msg","fun1");
        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request,response);
    }

    //使用SpringMVC实现视图转发和重定向，不需要视图解析器：
    @RequestMapping("/test/t2")
    public String fun2(Model model){
        model.addAttribute("msg","fun2");
        return "/WEB-INF/jsp/test.jsp";  //转发，不需要视图解析器,如果有视图解析器会拼接转发路径
    }

    @RequestMapping("/test/t3")
    public String fun3(Model model) {
        model.addAttribute("msg","fun3");
        return "forward:/WEB-INF/jsp/test.jsp";  // forward: 转发，不需要视图解析器，有视图解析器也不会拼接路径
    }

    @RequestMapping("/test/t4")
    public String fun4(Model model) {
        model.addAttribute("msg","fun4");
        return "redirect:/index.jsp";  // redirect: 重定向，不需要视图解析器，有视图解析器也不会拼接路径
    }


}
