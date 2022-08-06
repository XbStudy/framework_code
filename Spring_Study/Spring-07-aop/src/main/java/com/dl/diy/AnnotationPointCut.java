package com.dl.diy;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//方式三：使用注解方式实现AOP
@Aspect //标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.dl.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("===========方法执行前！！！========");
    }

    @After("execution(* com.dl.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("===========方法执行后！！！========");
    }

    //在环绕增强中，我们可以指定一个参数，代表我们要处理切入的点：
    @Around("execution(* com.dl.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        System.out.println(jp.getSignature());
        Object proceed = jp.proceed(); //执行方法
        System.out.println("环绕后");
    }

}
