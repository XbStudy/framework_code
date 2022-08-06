package com.dl.controller;

import com.dl.pojo.Books;
import com.dl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller层调service层
    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    //查询全部书籍，并返回到一个书籍展示页面：
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到新增书籍的页面：
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }

    //添加书籍：
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook==>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook"; //重定向到我们的 @RequestMapping("/allBook")
    }

    //跳转到修改页面：
    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(@RequestParam("id") int id, Model model){
        Books book = bookService.queryBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    //修改书籍：
    @RequestMapping("/updateBook")
    public String updateBook(Books book){
        System.out.println("updateBook---->"+book);
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    /*
        @PathVariable("xxx")
        通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
        @RequestMapping(value=”user/{id}/{name}”)
        请求路径：http://localhost:8080/hello/show5/1/james
     */
    //删除书籍：
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //按照名字模糊查询书籍：
    @RequestMapping("/queryBook")
    public String queryBook(@RequestParam("queryBookName") String queryBookName,Model model){
        System.out.println("queryBookName:"+queryBookName);
        List<Books> list = bookService.queryBookByName(queryBookName);
        System.out.println(list);
        model.addAttribute("list",list);
        return "allBook";
    }

    //按照id查询书籍 ：
    @RequestMapping("/queryBookById")
    public String queryBookById(int queryBookId,Model model){
        Books book = bookService.queryBookById(queryBookId);
        if (book == null){
            model.addAttribute("error","未查到");
            List<Books> list = bookService.queryAllBook();
            model.addAttribute("list",list);
        }else{
            List<Books> list = new ArrayList<>();
            list.add(book);
            model.addAttribute("list",list);
        }
        return "allBook";
    }


}
