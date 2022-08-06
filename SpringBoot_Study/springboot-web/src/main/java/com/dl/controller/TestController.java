package com.dl.controller;


import com.dl.pojo.Pet;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/re")
    public String testRequestParam(HttpServletRequest request) {
        System.out.println(request);
        return "ok";
    }

    @RequestMapping("/t")
    public String t(Pet pet) {
        System.out.println(pet);
        return pet.toString();
    }

    //1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    @RequestMapping("/cars/{path}")
    public Map test01(@MatrixVariable("low") Integer low,
                      @MatrixVariable("brand") List<String> brand,
                      @PathVariable("path") String path){
        HashMap<String, Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }


    // /boss/1;age=20/2;age=10
    @RequestMapping("/boss/{bossId}/{empId}")
    public Map test02(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                      @MatrixVariable(value = "age",pathVar = "empId") Integer empAge) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }

}
