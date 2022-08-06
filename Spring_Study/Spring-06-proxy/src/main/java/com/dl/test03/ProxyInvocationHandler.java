package com.dl.test03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理角色的处理角色
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的对象
    private Object obj;

    public void setHost(Object obj) {
        this.obj = obj;
    }

    /*
     *每个代理的实例（代理对象）都有一个与之关联的 InvocationHandler 实现类，
     *如果代理的方法被调用，那么代理便会通知和转发给内部的 InvocationHandler 实现类，由它决定处理。
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在执行方法之前可加入一些操作
        seeHouse();

        //通过反射执行方法
        Object o= method.invoke(obj,args);//这里的第一个参数是被代理的对象，不是代理对象

        //在执行方法之后可加入一些操作
        hetong();

        return o;
    }

    public void seeHouse(){
        System.out.println("中介带你看房子！");
    }

    public void hetong(){
        System.out.println("签合同！");
    }
}
