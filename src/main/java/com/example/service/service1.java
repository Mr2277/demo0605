package com.example.service;

import com.example.entry.sale;
import com.example.entry.ums_role;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface service1 {
  List<ums_role> findAll();
  String testRedis();
  void testTaskExecutor();
  List<ums_role>findAllFromTaskExecutor() throws ExecutionException, InterruptedException;
  Future<String>method6();
  List<ums_role>findAllmethod7() throws ExecutionException, InterruptedException;
  String findAllfromRedis();
  List<ums_role> readAllfromRedis();
  List<ums_role>findUmsFromMybatis();
  List<sale>findByBill(String BILL);
}
