package com.yfx.spring.boot.controller;

import com.yfx.spring.boot.dao.BookDAO;
import com.yfx.spring.boot.dao.PublisherDAO;
import com.yfx.spring.boot.entity.Book;
import com.yfx.spring.boot.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    BookDAO bookDAO;
    @Autowired
    PublisherDAO publisherDAO;

    @GetMapping("/bookall")
    public List<Book> toBookall(){
        List<Book> all = bookDAO.findAll();
        for (Book b:all) {
            System.out.println(b);
        }
        return all;
    }

    @GetMapping("/bookname")
    public Book toBookname(){
       // List<Book> all = bookDAO.findAll();

        return bookDAO.findByName("阿斯蒂芬2222");
    }
    @GetMapping("/bookid")
    public Book toBookid(){

        return bookDAO.getById(2);
    }


    @GetMapping("/puball")
    public List<Publisher> toPuball(){
        List<Publisher> all = publisherDAO.findAll();
        for (Publisher p : all) {
            System.out.println(p);
        }
        return all;
       // return publisherDAO.getPubliserAll();
    }



}

