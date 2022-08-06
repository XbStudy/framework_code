package com.dl.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dl.admin.pojo.Student;
import com.dl.admin.pojo.User;
import com.dl.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                                @RequestParam(value = "size",defaultValue = "3") Integer size,
                                Model model) {
//        List<User> users = Arrays.asList(new User("aa", "123456"),
//                new User("bb", "123456"),
//                new User("cc", "123456"),
//                new User("dd", "123456"),
//                new User("ee", "123456")
//        );
//        model.addAttribute("users",users);


//        List<User> users = userService.list();
//        model.addAttribute("users",users);

        System.out.println(pn+"---"+size);
        Page<User> userPage = new Page<User>(pn,size);
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page",page);
        return "table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") Long id,
                         @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                         RedirectAttributes ra) {  //重定向携带参数
        boolean b = userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }


    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table() {
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }
}


