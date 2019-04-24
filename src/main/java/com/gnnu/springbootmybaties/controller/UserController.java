package com.gnnu.springbootmybaties.controller;

import com.gnnu.springbootmybaties.mapper.UserMapper;
import com.gnnu.springbootmybaties.pojo.User;
import com.gnnu.springbootmybaties.repo.MyReponsityJPA;
import jdk.nashorn.internal.parser.JSONParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    MyReponsityJPA myReponsityJPA;

    @Autowired
    UserMapper userMapper;

    @PostMapping("/users")
    public JSONObject users() {
        JSONObject jsonObject = new JSONObject();
        List<User> userList = myReponsityJPA.findAll();
        try {
            jsonObject.put("rows", userList);
            Integer total = userList.size();
            jsonObject.put("total", total);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @PostMapping("/addUser")
    public User saveUser(@Param("uname") String uname, @Param("pwd") String pwd) {
        User user = new User();
        user.setPwd(pwd);
        user.setUname(uname);
        return myReponsityJPA.save(user);
    }

    @GetMapping(value = "/toEditUser")
    public User toEdit(User user) {
        user = userMapper.selectByUname(user);
        System.out.println(user);
        return user;
    }

    @PostMapping("/editUser")
    public String editUser(User user) {
        System.out.println(user);
        myReponsityJPA.save(user);
        //  int i =   userMapper.updateUser(user);
        String msg = "ojbk";
        return msg;
    }

    @PostMapping("/deleteUser")
    public int deleteUser(String uname) {
        return userMapper.deleteByName(uname);
    }

    @PostMapping("deleteList")
    public String deleteList(String ids) {
        System.out.println(ids);
        String msg = "";
        String[] ss = ids.split(",");
        for (String s : ss) {
            userMapper.deleteByName(s);
        }
        msg = "ojbk";
        return msg;
    }
}
