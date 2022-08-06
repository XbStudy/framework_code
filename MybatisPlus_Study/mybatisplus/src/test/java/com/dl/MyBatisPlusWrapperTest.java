package com.dl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.dl.mapper.UserMapper;
import com.dl.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test01(){
        // 姓名包含a，年龄>=18,小于等于30，邮箱不为null
        /**
         *  SELECT id,name,age,email,is_deleted FROM user
         *  WHERE is_deleted=0
         *  AND (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
         */
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","a")
                .between("age",18,30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        // 按年龄降序查询用户，如果年龄相同则按id升序排列
        /**
         *  SELECT id,name,age,email,is_deleted FROM user WHERE is_deleted=0 ORDER BY age DESC,id ASC
         */
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03(){
        /**
         * 是逻辑删除：
         * UPDATE user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
         */
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNull("email");
        int delete = userMapper.delete(wrapper);
        System.out.println(delete);
    }

    @Test
    public void test04(){
        // 将用户名中包含有a并且年龄大于19或邮箱为null的用户信息修改
        /**
         * UPDATE user SET email=? WHERE is_deleted=0 AND (age > ? AND name LIKE ? OR email IS NULL)
         */
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age",19)
                .like("name","a")
                .or()
                .isNull("email");
        User user = new User();
        user.setEmail("fsdhfj@fdsf");
        int update = userMapper.update(user, wrapper);
        System.out.println(update);
    }

    @Test
    public void test05(){
        /** 条件的优先级：在lambda表达式中的条件优先执行
         * 将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
         *  UPDATE user SET email=? WHERE is_deleted=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
         */
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","a")
                .and(wra -> wra.gt("age",20).or().isNull("email"));
        User user = new User();
        user.setEmail("zzzzzz@zzz");
        int update = userMapper.update(user, wrapper);
        System.out.println(update);
    }

    @Test
    public void test06(){
        /**
         * 查询用户信息的用户名和年龄字段:
         * SELECT name,age FROM user WHERE is_deleted=0
         */
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("name","age");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07(){
        /** 查询id小于等于4的用户信息:
         *   SELECT id,name,age,email,is_deleted FROM user WHERE is_deleted=0 AND (id IN (select id from user where id <= 4))
         */
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id","select id from user where id <= 4");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test08(){
        /** 将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改：
         *  UPDATE user SET name=?,email=? WHERE is_deleted=0 AND (name LIKE ? AND (age >= ? OR email IS NULL))
         */
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name","a")
                .and(wrapper -> wrapper.ge("age",20).or().isNull("email"))
                .set("name","ikun")
                .set("email","aaaaaa@aaa");
        userMapper.update(null,updateWrapper);
    }

    @Test
    public void test09(){
        /**
         * SELECT id,name,age,email,is_deleted FROM user WHERE is_deleted=0 AND (age > ? AND age < ?)
         */
        String name = "";
        Integer startAge = 18;
        Integer endAge = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.like("name",name);
        }
        if (startAge != null) {
            queryWrapper.gt("age",startAge);
        }
        if (endAge != null){
            queryWrapper.lt("age",endAge);
        }
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test10() {
        /**
         *  SELECT id,name,age,email,is_deleted FROM user WHERE is_deleted=0 AND (age > ? AND age < ?)
         *  SELECT id,name,age,email,is_deleted FROM user WHERE is_deleted=0 AND (name LIKE ? AND age > ? AND age < ?)
         */
        String name = "a";
        Integer startAge = 18;
        Integer endAge = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name),"name","a")
                .gt(startAge != null,"age",startAge)
                .lt(endAge != null,"age",endAge);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test11(){
        /**
         * SELECT id,name,age,email,is_deleted FROM user WHERE is_deleted=0 AND (name LIKE ? AND age > ? AND age < ?)
         * SELECT id,name,age AS t_age,email,is_deleted FROM user WHERE is_deleted=0 AND (name LIKE ? AND age > ? AND age < ?)
         */
        String name = "";
        Integer startAge = 18;
        Integer endAge = 30;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(name),User::getName,name)
                .gt(startAge != null,User::getAge,startAge)
                .lt(endAge != null,User::getAge,endAge);
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test12(){
        /** 将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改：
         *  UPDATE user SET name=?,email=? WHERE is_deleted=0 AND (name LIKE ? AND (age >= ? OR email IS NULL))
         */
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<User>();
        updateWrapper.like(User::getName,"a")
                .and(wrapper -> wrapper.ge(User::getAge,20).or().isNull(User::getEmail))
                .set(User::getName,"ikun")
                .set(User::getEmail,"zzzz@aaa");
        userMapper.update(null,updateWrapper);
    }



}
