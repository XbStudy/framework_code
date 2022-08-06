package com.dl.controller;

import com.dl.entity.Users;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/anno")
public class SecurityAnnotationController {

    // @Secured({"ROLE_role1","ROLE_role2"})：只有角色ROLE_role1，或ROLE_role2才能访问（进入）这个方法
    //@Secured({"ROLE_role1","ROLE_role2"})
    //@PreAuthorize：在方法调用前进行权限校验
    //@PreAuthorize("hasAnyRole('ROLE_role1')")
    //@PostAuthorize("hasAnyRole('ROLE_role1')"):在方法调用后进行权限校验，不决定方法是否执行，决定是否抛异常，如果校验不通过就会抛异常，会捕获进入没有权限的页面
    //@PostAuthorize("hasAnyRole('ROLE_role1')")
//    @PreFilter("filterObject.username!=null")
    @PostFilter("filterObject.username!=''")
    @GetMapping("/add")
    public List<Users> add(List<Users> list){
        System.out.println("------add-----");
        System.out.println(list);
        Users users = new Users();
        users.setId(1);
        users.setUsername("小白");
        users.setPassword("aaa");
        ArrayList<Users> usersArrayList = new ArrayList<>();
        return usersArrayList;
    }

    //@Secured("ROLE_role2"):只有角色ROLE_role2才能访问（进入）
    //@Secured("ROLE_role2")
    //@PreAuthorize("hasAnyRole('ROLE_role2','ROLE_role3')")
    // @PostAuthorize("hasAnyRole('ROLE_role2','ROLE_role3')")在方法调用后进行权限校验，不决定方法是否执行，决定的是否抛异常，如果校验不通过就会抛异常，会捕获进入没有权限的页面
    //@PostAuthorize("hasAnyRole('ROLE_role2','ROLE_role3')")
    @GetMapping("/delete")
    public String delete(){
        System.out.println("------delete-----");
        return "delete~~~";
    }


}
