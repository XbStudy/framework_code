package com.dl.admin.acutuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/***
 * 自定义info信息:
 *  实现InfoContributor接口,实现方法
 *  给类添加@Component注解
 *  最终展示结果是配置文件和自定义类的总和
 */
@Component
public class MyInfoInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");
        builder.withDetail("msg","你好")
                .withDetails(map);
    }
}
