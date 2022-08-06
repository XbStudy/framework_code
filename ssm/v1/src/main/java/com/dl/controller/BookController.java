package com.dl.controller;

import com.dl.pojo.Books;
import com.dl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/all")
    public String all(Model model){
        List<Books> list = bookService.getAllBook();
        model.addAttribute("msg",list);
        return "test";
    }
}
