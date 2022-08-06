package com.dl.admin;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

/**
 * assumptions:假设，前置条件
 *
 */
public class Junit5AssumptionsTest {

    /**
     *Assumptions.assumeTrue();
     * 我们的假设（前置条件）成立，后面的代码才会执行
     */
    @Test
    void test01() {
        Assumptions.assumeTrue(false);
        System.out.println("=====>");
    }
}
