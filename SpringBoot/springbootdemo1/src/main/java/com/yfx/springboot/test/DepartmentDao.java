package com.yfx.springboot.test;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    //静态数据
    static{
        departments = new HashMap<Integer, Department>();
        departments.put(101, new Department(101, "1-A"));
        departments.put(102, new Department(102, "2-B"));
        departments.put(103, new Department(103, "3-C"));
        departments.put(104, new Department(104, "4-D"));
    }

//    public void findAll(){
//        for(Integer key : departments.keySet()){
//            System.out.println(key+"---"+departments.get(key));
//        }
//    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public static Department getDepartment(Integer id){
        return departments.get(id);
    }
}
