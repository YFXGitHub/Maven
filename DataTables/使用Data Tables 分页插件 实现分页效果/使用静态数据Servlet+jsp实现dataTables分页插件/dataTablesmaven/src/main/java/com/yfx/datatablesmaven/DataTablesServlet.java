package com.yfx.datatablesmaven;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/test")
public class DataTablesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //super.doGet(req, resp);
        System.out.println("进入test........");
        List<User> list = new ArrayList<User>();
        User u1 = new User(1, "抓住你是哪", "男" , 23);
        User u2 = new User(2, "抓住你是哪2", "男" , 22);
        User u3 = new User(3, "抓住你是哪3", "女" , 44);
        User u4 = new User(4, "抓住你是哪4", "男" , 23);
        User u5 = new User(5, "抓住你是哪5", "女" , 33);
        User u6 = new User(6, "抓住你是哪6", "男" , 23);
        User u7 = new User(8, "抓住你是哪6", "男" , 23);
        User u8 = new User(9, "抓住你是哪6", "男" , 23);
        User u9 = new User(10, "抓住你是哪6", "男" , 23);
        User u10 = new User(11, "抓住你是哪6", "男" , 23);
        User u11= new User(12, "抓住你是哪6", "男" , 23);
        User u12= new User(13, "抓住你是哪6", "男" , 23);
        User u13= new User(14, "抓住你是哪6", "男" , 23);
        User u14= new User(15, "抓住你是哪6", "男" , 23);
        User u15= new User(16, "抓住你是哪6", "男" , 23);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        list.add(u6);
        list.add(u7);
        list.add(u10);
        list.add(u11);
        list.add(u12);
        list.add(u13);
        list.add(u14);
        list.add(u15);

        JSONObject obj = new JSONObject();
        obj.put("data", JSONArray.toJSON(list));
        System.out.println(obj.toJSONString());
        resp.getWriter().write(obj.toJSONString());
        /*
        {"data":[{"name":"抓住你是哪","id":1,"age":23,"sex":"男"},{"name":"抓住你是哪2","id":2,"age":22,"sex":"男"},{"name":"抓住你是哪3","id":3,"age":44,"sex":"女"},{"name":"抓住你是哪4","id":4,"age":23,"sex":"男"},{"name":"抓住你是哪5","id":5,"age":33,"sex":"女"},{"name":"抓住你是哪6","id":6,"age":23,"sex":"男"},{"name":"抓住你是哪6","id":8,"age":23,"sex":"男"},{"name":"抓住你是哪6","id":11,"age":23,"sex":"男"},{"name":"抓住你是哪6","id":12,"age":23,"sex":"男"},{"name":"抓住你是哪6","id":13,"age":23,"sex":"男"},{"name":"抓住你是哪6","id":14,"age":23,"sex":"男"},{"name":"抓住你是哪6","id":15,"age":23,"sex":"男"},{"name":"抓住你是哪6","id":16,"age":23,"sex":"男"}]}

         */
    }
}

class User{
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public User(Integer id, String name, String sex, Integer age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
