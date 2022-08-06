package com.dl.admin.interceptor;

import com.dl.admin.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截的地址："+request.getRequestURI());
        User user = (User) request.getSession().getAttribute("user");
        if ( user != null){
            //System.out.println(user.toString());
            return true;
        }
        request.setAttribute("msg","请先登录！！！");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }
}
