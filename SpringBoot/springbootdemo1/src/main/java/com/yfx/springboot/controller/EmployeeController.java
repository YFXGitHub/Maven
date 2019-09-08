package com.yfx.springboot.controller;

import com.yfx.springboot.test.Employee;
import com.yfx.springboot.test.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String employeeList(Model model){
        System.out.println("进入employeeList()..........");
        //查询所有数据，并回显在页面上！
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        System.out.println(all);
        //thymeleaf 默认会拼串  默认路径classpath:/templates/ ***.html
        return "emp/orders";
    }

    //添加之前的页面跳转
    @GetMapping("/addempPre")
    public String toaddempPre(){

        return "";
    }
}
