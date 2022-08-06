package com.dl.test03;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //真实对象
        Host host = new Host();
        //代理角色的处理程序
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //设置要代理的类
        handler.setHost(host);
        //动态创建代理对象
        Rent proxy = (Rent) Proxy.newProxyInstance(Rent.class.getClassLoader(), new Class[]{Rent.class}, handler);
        proxy.rent();
    }
}
