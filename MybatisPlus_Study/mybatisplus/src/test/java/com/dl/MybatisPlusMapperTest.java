package com.dl;

import com.dl.mapper.UserMapper;
import com.dl.pojo.User;
import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectList(){
        // 通过条件构造器来查询list集合，若参数为null，则表示没有条件，表示查所有：
        List<User> list = userMapper.selectList(null);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     *  INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
     */
    @Test
    public void insertUser(){
        User user = new User();
        // user.setId(99L);
        user.setName("小白啦啦啦啦啦啦啦");
        user.setAge(1);
        user.setEmail("66666@xx.com");
        userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    public void deleteUser(){
        /**
         *  DELETE FROM user WHERE id=?
         *
         *  有逻辑逻辑删除的字段： UPDATE user SET is_deleted=1 WHERE id=? AND is_deleted=0
         */
        int result = userMapper.deleteById(1L);
        System.out.println(result);

        /**
         * DELETE FROM user WHERE name = ? AND age = ?
         */
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name","小白");
//        map.put("age",20);
//        int i = userMapper.deleteByMap(map);
//        System.out.println(i);

        /**
         * DELETE FROM user WHERE id IN ( ? , ? , ? )
         */
//        List<Long> idList = Arrays.asList(1L, 2L, 3L);
//        int i1 = userMapper.deleteBatchIds(idList);
//        System.out.println(i1);
    }

    @Test
    public void updateUser(){
        /**
         * UPDATE user SET name=? WHERE id=?
         */
        User user = new User();
        user.setId(4L);
        user.setName("小白呀");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void selectUser(){
        /**
         * SELECT id,name,age,email FROM user WHERE id=?
         */
        // User user = userMapper.selectById(1l);
        // System.out.println(user);

        /**
         * SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? , ? )
         */
        // List<Long> idList = Arrays.asList(1L, 2L, 3L, 4L);
        // List<User> list = userMapper.selectBatchIds(idList);
        // list.forEach(System.out::println);

        /**
         *  SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
         */
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name","Jack");
//        map.put("age",20);
//        List<User> list = userMapper.selectByMap(map);
//        for (User user : list) {
//            System.out.println(user);
//        }

        /**
         * SELECT id,name,age,email FROM user
         * 逻辑删除：SELECT id,name,age,email,is_deleted FROM user WHERE is_deleted=0
         */
        List<User> list1 = userMapper.selectList(null);
        for (User user : list1) {
            System.out.println(user);
        }

        /**测试自定义的查询方法：
         * select * from user where id = ?
         */
//        Map<String, Object> map1 = userMapper.selectMapById(1l);
//        System.out.println(map1);
    }


}
