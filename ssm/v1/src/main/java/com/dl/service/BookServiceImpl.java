package com.dl.service;

import com.dl.mapper.BookMapper;
import com.dl.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Books> getAllBook() {
        return bookMapper.getAllBook();
    }
}
