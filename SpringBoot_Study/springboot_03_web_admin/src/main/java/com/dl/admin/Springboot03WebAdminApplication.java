package com.dl.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//扫描指定包下的 @WebFilter  @WebServlet("/myServlet") @WebListener
//@ServletComponentScan(basePackages="com.dl.admin")
@MapperScan(basePackages = "com.dl.admin.mapper") //扫描指定包下的Mapper，这样就不用在接口上标注@Mapper了
@SpringBootApplication
public class Springboot03WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03WebAdminApplication.class, args);
    }

}
