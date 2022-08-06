package com.dl;

import com.dl.service.ProductService;
import com.dl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusDatasourceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Test
    public void test01(){
        System.out.println(userService.getById(1L));
        System.out.println(productService.getById(1L));
    }

}
