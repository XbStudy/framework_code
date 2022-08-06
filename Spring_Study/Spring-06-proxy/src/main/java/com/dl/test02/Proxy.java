package com.dl.test02;

//代理增加一个日志功能,不改变原有的代码！
public class Proxy implements UserService {
    private UserService userService;

    // Spring建议使用set注入对象
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    public void update() {
        log("update");
        userService.update();
    }

    public void query() {
        log("query");
        userService.query();
    }

    //日志方法
    public void log(String msg){
        System.out.println("使用了"+msg+"方法！");
    }
}
