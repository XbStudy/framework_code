package com.dl.mapper;

import com.dl.pojo.Books;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class BookMapperImpl extends SqlSessionDaoSupport implements BookMapper {
    @Override
    public List<Books> getAllBook() {
        return getSqlSession().getMapper(BookMapper.class).getAllBook();
    }
}
