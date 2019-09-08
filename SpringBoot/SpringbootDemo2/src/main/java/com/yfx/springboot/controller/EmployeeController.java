package com.yfx.springboot.controller;

import com.yfx.springboot.test.Department;
import com.yfx.springboot.test.DepartmentDao;
import com.yfx.springboot.test.Employee;
import com.yfx.springboot.test.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/employeeList")
    public String toemployeeList(Model model){
        System.out.println("/employeeList");
        Collection<Employee> all = employeeDao.getAll();
        System.out.println(all);
        model.addAttribute("employeeList", all);
        return "emps/empsList";
    }

    //添加之前的操作
    @GetMapping("/employeeAddPre")
    public String toemployeeAddPre(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        System.out.println("departmentDao:"+departmentDao);

        return "emps/empsEdit";
    }

    @PostMapping("/employeeAdd")
    public String toemployeeAdd(Employee emp){
        System.out.println(emp);
        employeeDao.save(emp);
        return "redirect:/employeeList";
    }

    @GetMapping("/employeeDelete/{id}")
    public String toemployeeDelete(@PathVariable("id") Integer id){
        System.out.println("/employeeDelete"+id);
        return "redirect:/employeeList";
    }

    @GetMapping("/employeeUpdatePre/{id}")
    public String toemployeeUpdatePre(@PathVariable("id") Integer id){
        System.out.println("employeeUpdatePre"+id);
        return "redirect:/employeeList";
    }
}
