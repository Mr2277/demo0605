package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.entry.ums_role;
import com.example.service.service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("con1")
public class controller1 {
    @Autowired
    private service1 ser1;
    @RequestMapping("method1")
    public String method1(){
        System.out.println(System.currentTimeMillis());
        List<ums_role> list=ser1.findAll();
        String json= JSONArray.toJSONString(list);
        return json;
    }
}
