package com.dl.test02;

import java.lang.reflect.InvocationHandler;

public class Client {
    public static void main(String[] args) {
        UserService userService =new UserServiceImpl();
        Proxy proxy = new Proxy();
        proxy.setUserService(userService);
        proxy.add();
    }
}
