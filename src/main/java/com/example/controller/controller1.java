package com.example.controller;

import com.example.service.service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("con1")
public class controller1 {
    @Autowired
    private service1 ser1;
    @RequestMapping("method1")
    public String method1(){
        ser1.findAll();
        return "hello";
    }
}
