package com.dl.admin.acutuator.endPoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myEndPoint")
public class MyEndPoint {

    /**
     * 当我们访问请求:http://localhost:8080/actuator/myEndPoint,就会执行这个方法
     * @return
     */
    @ReadOperation
    public Map getXXX() {
        return Collections.singletonMap("xxxInfo","start.....");
    }

    /**
     *
     */
    @WriteOperation
    public void setXXX() {
        System.out.println("xxx stop...");
    }


}
