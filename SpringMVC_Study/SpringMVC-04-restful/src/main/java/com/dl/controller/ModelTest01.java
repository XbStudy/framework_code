package com.dl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ModelTest01 {

    @RequestMapping("/req")
    public String tset(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getSession().getId());
        return "test";
    }

}
