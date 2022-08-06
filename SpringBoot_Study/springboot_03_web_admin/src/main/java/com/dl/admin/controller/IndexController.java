package com.dl.admin.controller;

import com.dl.admin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping("/sql")
    @ResponseBody
    public String sql () {
        Long aLong = jdbcTemplate.queryForObject("select count(1) from student", Long.class);
        return aLong.toString();
    }


    @GetMapping(value = {"/","/index"})
    public String toIndex() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        //模拟登录校验：
        if ("admin".equals(user.getUserName())&&"111111".equals(user.getPassword())) {
            //登录成功,重定向：
            session.setAttribute("user",user);
            // 重定向到main.html请求，这样刷新页面就不会再重复提交表单
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号或密码错误！！！");
            // 返回登陆页面
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String toMain(HttpSession session,Model model) {
        //实际中使用拦截器,过滤器:
//        User user =(User) session.getAttribute("user");
////        if (user != null) {
////            return "main";
////        }else {
////            model.addAttribute("msg","请重新登录！！！");
////            return "login";
////        }
        return "main";
    }

}
