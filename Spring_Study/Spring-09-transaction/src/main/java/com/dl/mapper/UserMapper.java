package com.dl.mapper;

import com.dl.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> queryAll();

    //添加一个用户
    public int addUser(User user);

    //删除一个用户
    public int deleteUser(int id);

}
