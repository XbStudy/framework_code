package com.dl.mapper;

import com.dl.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    public List<User> queryAll() {
        return getSqlSession().getMapper(UserMapper.class).queryAll();
    }
}
