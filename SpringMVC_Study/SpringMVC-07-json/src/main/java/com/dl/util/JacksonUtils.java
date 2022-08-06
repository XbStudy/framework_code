package com.dl.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JacksonUtils {


    public static String getJackson(Object o,String dateFormat) {
        ObjectMapper jackson = new ObjectMapper();
        //1.将默认的时间转换格式关闭：
        jackson.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //2.再设置为自定义的日期格式：
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        jackson.setDateFormat(sdf);
        try {
            return jackson.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJackson(Object o){
        return getJackson(o,"yyyy-MM-dd HH:mm:ss");
    }

}
