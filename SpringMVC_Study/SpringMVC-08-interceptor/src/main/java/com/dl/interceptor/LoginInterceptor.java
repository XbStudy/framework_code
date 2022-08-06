package com.dl.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println(request.getRequestURI());

        //有session放行
        if (request.getSession().getAttribute("loginInfo")!=null){
            return true;
        }
        //要去登陆页面也要放行
        if (request.getRequestURI().contentEquals(request.getContextPath()+"/user/goLogin")){
            return true;
        }
        //登陆要放行
        if (request.getRequestURI().contentEquals(request.getContextPath()+"/user/login")){
            return true;
        }
        //没有登录跳转到登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
