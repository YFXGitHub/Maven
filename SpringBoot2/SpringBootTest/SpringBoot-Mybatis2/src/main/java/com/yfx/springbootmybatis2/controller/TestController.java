package com.yfx.springbootmybatis2.controller;

import com.yfx.springbootmybatis2.dao.RecordMapper;
import com.yfx.springbootmybatis2.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    RecordMapper recordMapper;

    @RequestMapping("/rec")
    public String toRec(){
        Record byId = recordMapper.findById(1);
        System.out.println(byId);

        return "yes";
    }
}
