package com.dl.admin;


import com.dl.admin.pojo.User;
import com.dl.admin.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@DisplayName("junit5功能测试类")
public class Junit5AnnotationTest {

    /**
     * junit是不能使用SprigBoot的注解的（即不会起作用的）
     * 可以在这个类上加上@SpringBootTest注解
     */
    @Autowired
    UserService userService;

    /**
     * 会在每个单元测试方法执行之前执行
     */
    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试要开始了~");
    }

    /**
     * 会在每个单元测试方法结束之后执行执行
     */
    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了~");
    }

    /**
     * 在所有的单元测试方法执行之前执行
     * 这个方法必须是static的
     */
    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有单元测试要开始了~~~~~");
    }

    /**
     * 在所有的单元测试方法执行之前执行
     * 这个方法必须是static的
     */
    @AfterAll
    static void testAfterAll() {
        System.out.println("所有单元测试结束了~~~~~");
    }

    @DisplayName("测试DisplayName注解")
    @Test
    void testDisplayName() {
        System.out.println("xxx~");
    }

    @Test
    void test01() {
        System.out.println("ddd~");
    }

    /**
     * @Disabled
     * 这个测试方法不会执行：
     */
    @Disabled
    @Test
    void test02() {
        System.out.println("hhh~");
    }

    /**
     * 超过指定时间还没执行完就算超时
     * 超时就抛异常
     */
    @Disabled
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void test03() throws InterruptedException {
        Thread.sleep(800);
    }

    /**
     * @RepeatedTest(n)
     * 会重复执行n次
     */
    @RepeatedTest(5)
    void test04() {
        List<User> list = userService.list();
        System.out.println("重复执行");
    }



}
