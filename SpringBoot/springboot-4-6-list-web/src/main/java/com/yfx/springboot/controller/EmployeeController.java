package com.yfx.springboot.controller;

import com.yfx.springboot.test.Department;
import com.yfx.springboot.test.DepartmentDao;
import com.yfx.springboot.test.Employee;
import com.yfx.springboot.test.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    //列表
    @GetMapping("/empList")
    public String toempList(Model model){
        System.out.println("进入empsList.......");
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("empList", all);
        System.out.println(all);
        //thymeleaf 默认会拼串  默认路径classpath:/templates/ ***.html
        return "emps/orders";
    }

    //添加之前的页面跳转
    @GetMapping("/empaddPre")
    public String toempaddPre(Model model){
        System.out.println("添加之前的操作！ 查询所有的部门，到form表单中的select");
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        System.out.println(departments);
        return "emps/ordersAdd";
    }

    //添加
    @PostMapping("/empAdd")
    public String toempAdd(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        //添加完成后 直接重定向列表
        return "redirect:/empList";
    }

    @GetMapping("/empupdatePre/{id}")
    public  String toempupdatePre(@PathVariable("id") Integer id, Model model){
        System.out.println("修改之前的操作："+id);
        Employee employee = employeeDao.get(id);      //获取当前用户的信息
        Collection<Department> departments = departmentDao.getDepartments();  //获取用户的类型列表
        model.addAttribute("emps", employee);
        model.addAttribute("deps", departments);
        return "emps/ordersUpdate";
    }

    @PostMapping("/empUpdate")
    public String toempUpdate(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/empList";
    }

    @RequestMapping("/empDelete/{id}")
    public String toempDelete(@PathVariable("id") Integer id){
        System.out.println("empDelete:"+id);
        employeeDao.delete(id);
        return "redirect:/empList";
    }
}
