package com.dl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dl.pojo.User;
import com.dl.util.JacksonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController  //使用了这个注解，这个类的所有方法都不走视图解析器，直接返回字符串
public class UserController {

//=====Jackson:
    // @ResponseBody //加了这个注解，那么就不会走视图解析器了，该方法会直接把字符串返回到前端
    // @Controller + @ResponseBody = @RestController
    // @RequestMapping(value = "/j1",produces = "application/json;charset=utf-8") //produces设置响应体的返回类型和编码，不常用
    //返回对象：
    @RequestMapping("/j1")
    public String json1() throws JsonProcessingException {
        User user = new User("小白", 3, "男");
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(user);
        return str;  // {"name":"??","age":3,"sex":"?"}
    }

    //返回集合：
    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        User user1 = new User("小白1", 3, "男");
        User user2 = new User("小白2", 3, "男");
        User user3 = new User("小白3", 3, "男");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(userList);
        return str;
        /*
            [{"name":"小白1","age":3,"sex":"男"},
             {"name":"小白2","age":3,"sex":"男"},
             {"name":"小白3","age":3,"sex":"男"}]
         */
    }

    //返回时间：方式一：使用SimpleDateFormat格式化输出
        //时间解析后的默认格式为时间戳-Timestamp
        //return objectMapper.writeValueAsString(date);   //1647076430582
    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = sdf.format(date);
        return objectMapper.writeValueAsString(formatDate);  // "2022-03-12 17:25:48"
    }

    //返回时间：使用ObjectMapper格式化输出
    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Date date = new Date();
        //1.将默认的时间转换格式关闭：
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //2.再设置为自定义的日期格式：
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(sdf);
        return objectMapper.writeValueAsString(date);  // "2022-03-12 17:37:15"
    }

    //使用自己提取的具类：
    @RequestMapping("/j5")
    public String json5() {
        Date date = new Date();
        return JacksonUtils.getJackson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("/j6")
    public String json6(){
        User user1 = new User("小白1", 3, "男");
        User user2 = new User("小白2", 3, "男");
        User user3 = new User("小白3", 3, "男");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return JacksonUtils.getJackson(userList);
    }

//======Fastjson:
    @RequestMapping("/j7")
    public String json7(){
        User user1 = new User("小白1", 3, "男");
        User user2 = new User("小白2", 3, "男");
        User user3 = new User("小白3", 3, "男");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        //Java对象 转 JSON字符串
        String jsonString = JSON.toJSONString(userList);
        //JSON字符串 转 Java对象  parseArray   parseObject
        List<User> list = JSON.parseArray(jsonString, User.class);
        for (User user : list) {
            System.out.println(user);
        }
        return jsonString;  //[{"age":3,"name":"小白1","sex":"男"},{"age":3,"name":"小白2","sex":"男"},{"age":3,"name":"小白3","sex":"男"}]
    }



}
