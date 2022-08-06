package com.dl.pojo;

public class User {

    private String name;

    public User() {
        System.out.println(this.name+"通过无参构造创建！");
    }

    public User(String name) {
        this.name = name;
        System.out.println(this.name+"通过无参构造创建！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
