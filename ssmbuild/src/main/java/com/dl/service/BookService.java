package com.dl.service;

import com.dl.pojo.Books;

import java.util.List;

public interface BookService {
    int addBook(Books books);

    int deleteBookById(int id);

    int updateBook(Books books);

    List<Books> queryAllBook();

    Books queryBookById(int id);

    List<Books> queryBookByName(String bookName);
}
