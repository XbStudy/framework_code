package com.dl.dao;

import com.dl.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUserById(@Param("id") int id);

    int updateUser(User user);


}
