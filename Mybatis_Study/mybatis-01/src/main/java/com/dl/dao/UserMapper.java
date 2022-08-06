package com.dl.dao;

import com.dl.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //查询全部
    List<User> getUserList();

    //根据id查
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);

    //利用map传参
    int addUser2(Map<String,Object> map);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    //使用sql分页
    List<User> getLimit(Map<String,Integer> map);

    //使用RoeBounds类分页
    List<User> getLimit2();

}
