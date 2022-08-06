package com.dl.mapper;

import com.dl.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<User> queryAll() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.queryAll();
    }
}
