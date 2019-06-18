package com.example.service.imp;

import com.example.dao.dao1;
import com.example.entry.sale;
import com.example.entry.ums_role;
import com.example.service.service1;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@Service
public class service1imp implements service1 {
    @Autowired
    private dao1 d1;
    @Autowired
    @Qualifier("asyncServiceExecutor")
    public ThreadPoolTaskExecutor taskExecutor;

    @Override
    //@Async
    public List<ums_role> findAll() {

        return d1.method1();
    }
    @Override
    public String testRedis() {
        return d1.testRedis();
    }

    @Override
    @Async
    public void testTaskExecutor() {
        LoggerFactory.getLogger(service1imp.class).info("TaskExecutor");
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    //@Async
    public List<ums_role> findAllFromTaskExecutor() throws ExecutionException, InterruptedException {
        //ListenableFuture<List<ums_role>>listenableFuture=new AsyncResult<>(d1.method1());
        //List<ums_role>list=listenableFuture.get();
        //System.out.println(list.size());
        return d1.method1();
    }

    @Override
    @Async

    public Future<String> method6() {

        return new AsyncResult<String>("method6");
    }

    @Override
    public List<ums_role> findAllmethod7() throws ExecutionException, InterruptedException {
        Future<List<ums_role>>future=d1.findmethod7();
        List<ums_role>list=future.get();
        return list;
    }

    @Override
    public String findAllfromRedis() {
        d1.selectFromRedis();
        return null;
    }

    @Override
    public List<ums_role> readAllfromRedis() {
        return d1.readFromRedis();

    }

    @Override
    public List<ums_role> findUmsFromMybatis() {
        return d1.method9();
    }

    @Override
    public List<sale> findByBill(String BILL) {

        return d1.selectSaleFromRedis(BILL);
    }

    @Override
    public List<sale> findSaleByBillFromMybatis(String BILL) {
        return d1.selectSaleFromMybatis(BILL);
    }

}
