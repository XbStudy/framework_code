package com.dl.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器是AOP思想的具体实现
 * 拦截器只会拦截访问的控制方法，不会拦截jsp,html,css,js,image
 * 自定义拦截器：实现HandlerInterceptor接口
 */
public class TestInterceptor implements HandlerInterceptor {

    //return true：放行，执行下一个拦截器
    //return false ：不执行下一个拦截器
    //这个方法会在控制方法执行前（请求执行前）执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=====处理前======");
        return true;
    }

    /*
    //这个方法会在控制方法执行后（请求执行后）执行
    //一般用于日志
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("=====处理后=======");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("=====清理========");
    }
     */

}
