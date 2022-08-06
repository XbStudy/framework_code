package com.dl.test01;

// 客户
public class Client {
    public static void main(String[] args) {
        //房东要出租房子
        Host host = new Host();
        //中介帮房东出租房子，中介一般都有一些附属操作
        Proxy proxy = new Proxy(host);
        //客户不要直接面对房东，直接找中介
        proxy.rent();
    }
}
