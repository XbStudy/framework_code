package com.dl.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Log implements MethodBeforeAdvice {
    /**
     * 这个方法会在方法执行之前自动调用
     * @param method：要执行的目标对象的方法
     * @param args：方法的参数
     * @param target：目标对象
     * @throws Throwable
     */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"类的"+method.getName()+"方法被执行了！");
    }
}
