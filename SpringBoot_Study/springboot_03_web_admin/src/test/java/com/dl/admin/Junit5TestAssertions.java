package com.dl.admin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试Junit5的断言")
public class Junit5TestAssertions {

    /**
     * 如果断言失败后面的代码就都不会执行了
     */

    /**
     * Assertions.assertEquals(a,b,c)
     * a:是我们预期的值
     * b:是实际产生的值
     * c:可选，自定义断言失败的提示信息
     */
    @Test
    void test01() {
        Assertions.assertEquals(5,10);
    }

    /**
     * Assertions.assertSame(a,b,c)
     * 判断a和b是否是同一个对象，比较地址值，
     * c:可选，自定义断言失败的提示信息
     */
    @Test
    void test02() {
        Assertions.assertSame(new Object(),new Object());
    }

    /**
     * Assertions.assertArrayEquals(a,b,c)
     * 判断数组里面的内容是否相等
     * c:可选，自定义断言失败的提示信息
     */
    @Test
    void test03() {
        Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2});
    }

    /**组合断言：
     * Assertions.assertAll()
     * 只要有一个断言失败，就会提示断言失败
     */
    @Test
    void test04() {
        Assertions.assertAll(
                ()-> Assertions.assertTrue(true==true),
                ()-> Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2})
        );
    }

    /**异常断言：
     * Assertions.()
     * 断定业务逻辑一定会抛出某个异常
     */
    @Test
    void test05() {
        Assertions.assertThrows(ArithmeticException.class,()-> {
            int i = 10/1;
        },"断言失败！！！");
    }

    /**快速失败：
     * Assertions.fail();
     * 直接使得断言失败
     */
    @Test
    void test06() {
        System.out.println("===>");
        Assertions.fail();
    }





}
