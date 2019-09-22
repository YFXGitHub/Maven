package com.yfx.spring.boot.controller;

import com.yfx.spring.boot.dao.PublisherDAO;
import com.yfx.spring.boot.entity.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pub")
public class PublisherController {

    private static final Logger log = LoggerFactory.getLogger(PublisherController.class);

    @Autowired
    private PublisherDAO publisherDAO;

    @GetMapping("/all")
    public String toAll(Model model){
        List<Publisher> all = publisherDAO.findAll();
        model.addAttribute("pub", all);
        return "publisher";
    }

    @GetMapping("/updatePre/{id}")
    public String  toupdatePre(@PathVariable("id") Integer id, Model model){
        log.info("Pub 修改之前的查询 {}", id);
        Publisher publisher = publisherDAO.getOne(id);
        model.addAttribute("pub", publisher);
        return "pubUpdate";
    }

    @PostMapping("/update")
    public  String toUpdate(Publisher publisher){
        log.info("Pub 修改 {}", publisher);
        publisherDAO.save(publisher);
        return "redirect:all";
    }

    @GetMapping("/delete/{id}")
    public String  todelete(@PathVariable("id") Integer id){
        log.info("Pub 删除 {}", id);
        publisherDAO.deleteById(id);
        return "redirect:/pub/all";
    }

}
