package com.dl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Random;

/**
 * 完成一个手机验证码功能:单个手机号每天只能发送3次
 */
@RequestMapping("/redis")
@RestController
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/code")
    public String test(){
        // 前端传过来手机号
        String phone = "13333333333";
        boolean b = saveCode(phone, generaCode());
        if (b){ //验证
            String code = "111111";
            if (verifyCode(phone,code)){
                System.out.println("验证码正确！！！");
            }else {
                System.out.println("验证码有误！！！");
            }
            return "ok";
        }
        return "没次数了";


    }

    // 生成验证码：
    public String generaCode(){
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            int c = random.nextInt(10);
            code += c;
        }
        System.out.println(code);
        return code;
    }

    // 保存到redis中
    public boolean saveCode(String phone,String code){
        // 发送次数的key:
        String countKey = "countKey:"+phone;
        // 验证码的key:
        String codeKey = "codeKey:"+phone;
        Integer count = (Integer) redisTemplate.opsForValue().get(countKey.toString());
        if (null == count){ //直接存
            redisTemplate.opsForValue().set(codeKey,code,Duration.ofSeconds(2*60));
            redisTemplate.opsForValue().set(countKey,1,Duration.ofDays(1));
        }else{
            if (count <= 2){
                redisTemplate.opsForValue().set(codeKey,code,Duration.ofSeconds(2*60));
                redisTemplate.opsForValue().increment(countKey,1);
            }else if(count >= 3){
                System.out.println("今日的次数超过限制！！");
                return false;
            }
        }
        return true;
    }

    // 验证：
    public boolean verifyCode(String phone,String code){
        String redisCode = (String) redisTemplate.opsForValue().get("codeKey:" + phone);
        if (code.equals(redisCode)){
            return true;
        }
        return false;
    }

}
