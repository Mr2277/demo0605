package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("con1")
public class controller1 {
    @RequestMapping("method1")
    public String method1(){
        return "hello";
    }
}
