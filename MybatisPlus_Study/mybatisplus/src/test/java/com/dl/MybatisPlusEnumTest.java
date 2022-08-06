package com.dl;

import com.dl.enums.Sex;
import com.dl.mapper.UserMapper;
import com.dl.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusEnumTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test01() {
        /**
         * UPDATE user SET name=?, sex=? WHERE id=? AND is_deleted=0
         */
        User user = new User();
        user.setId(1L);
        user.setName("小白");
        user.setSex(Sex.MAN);
        userMapper.updateById(user);
    }
}
