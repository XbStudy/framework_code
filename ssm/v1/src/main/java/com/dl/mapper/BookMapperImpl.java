package com.dl.mapper;

import com.dl.pojo.Books;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class BookMapperImpl implements BookMapper {

    SqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Books> getAllBook() {
        return sqlSessionTemplate.getMapper(BookMapper.class).getAllBook();
    }
}
