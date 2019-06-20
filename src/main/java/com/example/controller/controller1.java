package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.config.ExecutorConfig;
import com.example.entry.sale;
import com.example.entry.ums_role;
import com.example.service.service1;

import io.lettuce.core.internal.Futures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@RestController
@RequestMapping("con1")
public class controller1 {
    @Autowired
    private service1 ser1;
    @Autowired
    private ExecutorConfig executorConfig;
    @Autowired
    @Qualifier("MyRedisTemplate")
    private RedisTemplate myRedisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
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
    @RequestMapping("method6")
    public String method6() throws ExecutionException, InterruptedException {
        Future<String>future=ser1.method6();
        String str=future.get();
        System.out.println(str);
        return str;
    }
    @RequestMapping("method7")
    public String method7() throws ExecutionException, InterruptedException {
        //List<ums_role>list=new ArrayList<>();
        //list=ser1.findAllmethod7();
        List<ums_role>list=ser1.findAllmethod7();
        String json=JSONArray.toJSONString(list);
        return json;
    }
    @RequestMapping("method8")
    public String method8(){
        ser1.findAllfromRedis();
        return null;
    }
    @RequestMapping("method9")
    public String method9(){
        List<ums_role>list=ser1.readAllfromRedis();
        String json=JSONArray.toJSONString(list);
        return json;
    }
    @RequestMapping("method10")
    public String method10(){
        List<ums_role>list=ser1.findUmsFromMybatis();
        String json=JSONArray.toJSONString(list);
        return json;
    }
    @RequestMapping("method11")
    public String method11(@RequestParam("BILL")String BILL){
        List<sale>list=ser1.findByBill(BILL);
        String json=JSONArray.toJSONString(list);
        return json;
    }
    @RequestMapping("method12")
    public String method12(@RequestParam("BILL")String BILL){
        List<sale>list=ser1.findSaleByBillFromMybatis(BILL);
        String json=JSONArray.toJSONString(list);
        return json;

    }
    @RequestMapping("method13")
    public String method13(){
        List<ums_role>list=ser1.findUmsFromMybatis();

        ser1.testMongo(list);
        return null;
    }
    @RequestMapping("method14")
    public String method14(){
        List<ums_role>list=ser1.findAllUmaroleFromMongo();
        String json=JSONArray.toJSONString(list);
        return json;
    }
    @RequestMapping("method15")
    public String method15(){
       return  stringRedisTemplate.opsForValue().get("A");
    }
}
