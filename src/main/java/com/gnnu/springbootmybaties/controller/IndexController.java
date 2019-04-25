package com.gnnu.springbootmybaties.controller;

import com.gnnu.springbootmybaties.pojo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping("/{path}")
    public String toPath(@PathVariable("path") String path){
        return path;
    }
    @GetMapping("/")
    public String toIndex(HttpServletRequest request){
/*        HttpSession session = request.getSession();
        User  user = new User();
        user.setPwd("123");
        user.setUname("fuck");
        session.setAttribute("user",user);*/
        return "login";
    }

}
