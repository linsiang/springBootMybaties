package com.gnnu.springbootmybaties.service;

import com.gnnu.springbootmybaties.mapper.UserMapper;
import com.gnnu.springbootmybaties.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public int login(User user, HttpServletRequest request) {
        int i = userMapper.login(user);
        if(i==1){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
        }else{
        }
        return i;
    }
}
