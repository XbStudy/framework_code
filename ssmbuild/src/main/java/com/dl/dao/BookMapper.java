package com.dl.dao;

import com.dl.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    int addBook(Books books);

    int deleteBookById(@Param("bookID") int id);

    int updateBook(Books books);

    List<Books> queryAllBook();

    Books queryBookById(@Param("bookID") int id);

    List<Books> queryBookByName(@Param("bookName") String bookName);

}
