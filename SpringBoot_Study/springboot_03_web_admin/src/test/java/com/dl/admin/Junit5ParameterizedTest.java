package com.dl.admin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

/**
 * 参数化测试：
 */
public class Junit5ParameterizedTest {

    /**
     * @ParameterizedTest ：标注这个测试不是一个普通的测试，而是一个参数化测试
     * @ValueSource ：指定参数的来源，有几个参数就会执行几次
     */
    @ParameterizedTest
    @ValueSource(ints={1,2,3,4,5})
    void test01(int a) {
        System.out.println(a);
    }

    /**
     *
     * @MethodSource("stringProvider") :从指定的方法中获取值，这个方法必须是静态的，且返回值为Stream
     */
    @ParameterizedTest
    @MethodSource("stringProvider")
    void test02(String a) {
        System.out.println(a);
    }
    static Stream<String> stringProvider() {
        return Stream.of("apple","banana","watermelon");
    }


}
