package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.config.ExecutorConfig;
import com.example.entry.ums_role;
import com.example.service.service1;

import io.lettuce.core.internal.Futures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("con1")
public class controller1 {
    @Autowired
    private service1 ser1;
    @Autowired
    private ExecutorConfig executorConfig;
    @RequestMapping("method1")
    public String method1(){
        List<ums_role> list=ser1.findAll();
        String json= JSONArray.toJSONString(list);
        return json;
    }
    @RequestMapping("method2")
    public String method2(){
        return  ser1.testRedis();
    }
    @RequestMapping("method3")
    public void method3(){
        ser1.testTaskExecutor();
    }
    @RequestMapping("method4")
    @Async
    public String method4() throws ExecutionException, InterruptedException {
        //List<ums_role> list=ser1.findAllFromTaskExecutor();
        //String json= JSONArray.toJSONString(list);
        //ListenableFuture<List<ums_role>> listenableFuture=new AsyncResult<>(ser1.findAllFromTaskExecutor());
        //List<ums_role>list=listenableFuture.get();
        //List<ums_role>list=listenableFuture.completable().get();
        //listenableFuture.completable().
        //String json=JSONArray.toJSONString(list);
        CompletableFuture<List<ums_role>>completableFuture=new CompletableFuture<>();
        ser1.findAllFromTaskExecutor();
        System.out.println(completableFuture.get());
        return "json";
    }
}
