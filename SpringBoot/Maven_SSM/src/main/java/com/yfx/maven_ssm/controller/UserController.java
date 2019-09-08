package com.yfx.maven_ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yfx.maven_ssm.model.User;
import com.yfx.maven_ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //登录验证帐号、密码
    @RequestMapping("/findUserByName")
    public String tofindUserByName(@RequestParam("username") String uname, @RequestParam("password") String pwd, HttpSession session){
        logger.info("info is username {} - password {}", uname, pwd);
        User userByName = userService.findUserByName(uname);

       if(userByName != null){
           if(uname.equals(userByName.getUname()) && pwd.equals(userByName.getPwd())){
               session.setAttribute("user", userByName);
               return "list";
           }
       }
        return "login";
    }

    //查询所有的User 数据
    @RequestMapping("/findUserAll")
    public String tofindUserAll(){
        List<User> userAll = userService.findUserAll();
        logger.info("info is : {}", JSONArray.toJSONString(userAll));
        return "userList";
    }

    @RequestMapping("/findUserPage")
    @ResponseBody
    public String  tofindUserPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        List<User> userAll = userService.findUserAll();
        //String strjson = "{'data':"+JSONArray.toJSONString(userAll)+"}";
        JSONObject obj = new JSONObject();
        obj.put("data", userAll);
        logger.info("json : {}", obj.toJSONString());
        //json 格式 {"aaData":{"id":"yyyy","name":"nnnn"}}
       return obj.toJSONString();
    }

    @RequestMapping("/json2")
    @ResponseBody       //提交json数据
    public String toJson2(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        logger.info("toJson2................");
        List<User> userAll = userService.findUserAll();
        JSONObject obj = new JSONObject();
        obj.put("data", userAll);
        logger.info("json : {}", obj.toJSONString());
        return obj.toJSONString();
    }
}
