package com.dl.controlle;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ParameterTestController {

    /**
     * @PathVariable Map<String,String> map ：将所有的请求参数封装到这个集合中
     * @RequestHeader("User-Agent") String userAgent ：获取指定的请求头信息
     * @RequestHeader Map<String,String> headerMap : 封装所有的请求头信息到这个集合中
     * @CookieValue("_ga") String cookieValue ：封装cookie的值
     * @CookieValue("_ga") Cookie cookie：封装Cookie对象
     */
    // 请求路径 http://localhost:8888/car/1001/owner/小白?sex=男&age=3
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> get(@PathVariable Map<String,String> map,
                                   @PathVariable("id") Integer id,
                                   @PathVariable("username")String username,
                                   @RequestHeader("User-Agent") String userAgent,
                                   @RequestHeader Map<String,String> headerMap,
                                   @RequestParam("age") Integer age,
                                   @RequestParam("sex") String sex,
                                   @RequestParam Map<String,String> params
                                  // @CookieValue("_ga") String cookieValue,
                                  // @CookieValue("_ga") Cookie cookie
    ) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("username",username);
        hashMap.put("id",id);
        hashMap.put("map",map);
        hashMap.put("userAgent",userAgent);
        hashMap.put("headerMap",headerMap);
        hashMap.put("age",age);
        hashMap.put("sex",sex);
        hashMap.put("params",params);
        return hashMap;
    }

    /**只有POST请求才有请求体
     * @return
     */
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content) {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // /boss/1;age=20/2;age=30
    @RequestMapping("/boss/{bossId}/{empId}")
    // 使用矩阵变量：需要开启支持，默认是禁用的
    // 矩阵变量和路径变量绑定
    // 我们需要定制化webmvc：源码：configurePathMatch() ---> UrlPathHelper ---> removeSemicolonContent = true;
    @ResponseBody
    public Map pa(@PathVariable("bossId") Integer bossId,
                  @PathVariable("empId") Integer empId,
                  @MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                  @MatrixVariable(value = "age",pathVar = "empId") Integer empAge) {

        HashMap<Object,Integer> map = new HashMap<>();
        map.put("bossId：",bossId);
        map.put("empId：",empId);
        map.put("bossAge：",bossAge);
        map.put("empAge：",empAge);
        return map;
    }

}
