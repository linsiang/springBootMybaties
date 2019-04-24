package com.gnnu.springbootmybaties.controller;

import com.gnnu.springbootmybaties.pojo.Poetry;
import com.gnnu.springbootmybaties.service.PoetryService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PoetryController {
    @Autowired
    PoetryService poetryService;

    @PostMapping("/poetryList")
    public JSONObject poetryList() {
        JSONObject jsonObject = new JSONObject();
        List<Poetry> poetryList = poetryService.findAll();
        int total = poetryList.size();
        jsonObject.put("rows", poetryList);
        jsonObject.put("total", total);
        return jsonObject;

    }

    @PostMapping("/deletePoetry")
    public int deletePoetry(String poetryId) {
        System.out.println(poetryId);
        int i = poetryService.deletePoetryById(poetryId);
        return i;
    }

    @GetMapping("/toEditPoetry")
    public Poetry toEditPoetry(String poetryId) {
        return poetryService.findById(poetryId);

    }

    @PostMapping("/editPoetry")
    public String editPoetry(Poetry poetry) {

        int i = poetryService.editPoetry(poetry);
        String msg = "";
        if (i == 1) {
            msg = "ojbk";
        } else {
            msg = "error";
        }
        return msg;
    }

    @PostMapping("/addPoetry")
    public String addPoetry(Poetry poetry){
        System.out.println(poetry);
        int i = poetryService.addPoetry(poetry);
        String msg="";
        if(i==1){
            msg="ojbk";
        }
        return msg;
    }

    @PostMapping("/deletePoetrys")
    public String deletePoetrys(String ids){
        System.out.println(ids);
        String[] ss = ids.split(",");
        int i ;
        for(String s:ss){
            i = Integer.parseInt(s);
            poetryService.deletePoetryById(s);
        }
        return "ojbk";
    }

}
