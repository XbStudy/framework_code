package com.dl;

import com.dl.pojo.User;
import com.dl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    UserService userService;

    /**
     * SELECT COUNT( * ) FROM user
     */
    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println(count);
    }

    /**
     * INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
     */
    @Test
    public void testBatchSave(){
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("小白"+i);
            user.setAge(10+i);
            users.add(user);
        }
        boolean b = userService.saveBatch(users);
        System.out.println(b);
    }

}
