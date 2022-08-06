package com.dl.test04;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyHandler proxyHandler = new ProxyHandler();
        proxyHandler.setTarget(userService);
        UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), proxyHandler);
        proxy.add();
    }
}
