package com.dl.test03;

//真实角色 --- 房东 ， 实现接口
public class Host implements Rent {
    public void rent() {
        System.out.println("房东出租房子！");
    }
}
