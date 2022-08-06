package com.dl.dao;

import com.dl.pojo.Books;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

//方式一：继承SqlSessionDaoSupport，不需要在spring中注册SqlSessionTemplate
public class BootMaooerImpl1 extends SqlSessionDaoSupport implements BookMapper {
    @Override
    public int addBook(Books books) {
        return getSqlSession().getMapper(BookMapper.class).addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return 0;
    }

    @Override
    public int updateBook(Books books) {
        return 0;
    }

    @Override
    public Books queryBookById(int id) {
        return null;
    }

    @Override
    public List<Books> queryAllBook() {
        return null;
    }
}
