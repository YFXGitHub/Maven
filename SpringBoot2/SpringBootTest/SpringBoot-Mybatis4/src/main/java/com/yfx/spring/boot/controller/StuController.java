package com.yfx.spring.boot.controller;

import com.yfx.spring.boot.model.Stu;
import com.yfx.spring.boot.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {
    @Autowired
    private StuService stuService;

    @GetMapping("/findAll")
    public String toFindAll(Model model){
        model.addAttribute("stuList", stuService.findAll());
        return "stuList";
    }
}
