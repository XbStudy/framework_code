package com.dl.admin;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dl.admin.mapper.UserMapper;
import com.dl.admin.pojo.Student;
import com.dl.admin.pojo.User;
import com.dl.admin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class Springboot03WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    void testUserMapper() {
        User user = userMapper.selectById(1l);
        System.out.println("用户信息："+user);
    }

    @Test
    void testPage() {
        Page<User> userPage = new Page<User>(1,2);
        Page<User> page = userService.page(userPage, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        for (User record : page.getRecords()) {
            System.out.println(record);
        }
    }

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(1) from student", Long.class);
        System.out.println("总的记录数："+aLong);

        System.out.println("数据源类型:"+dataSource.getClass());
    }

}
