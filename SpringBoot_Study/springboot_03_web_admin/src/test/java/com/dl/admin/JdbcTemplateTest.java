package com.dl.admin;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@DisplayName("测试SpringBoot的JdbcTemplate")
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate JdbcTemplate;


}
