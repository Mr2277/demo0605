package com.example.service;

import com.example.entry.ums_role;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface service1 {
  List<ums_role> findAll();
  String testRedis();
  void testTaskExecutor();
  List<ums_role>findAllFromTaskExecutor() throws ExecutionException, InterruptedException;
}
