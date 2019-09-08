package com.yfx.springboot.test;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "AA", 0, new Date(), new Department(101, "1-A")));
        employees.put(1002, new Employee(1002, "BB", 1, new Date(), new Department(102, "2-B")));
        employees.put(1003, new Employee(1003, "CC", 0, new Date(), new Department(103, "3-C")));
        employees.put(1004, new Employee(1004, "DD", 1, new Date(), new Department(104, "4-D")));
    }
    private static Integer initID = 1005;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initID++);
        }
        employee.setDepartment(DepartmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee get(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

}
