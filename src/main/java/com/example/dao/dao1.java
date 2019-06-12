package com.example.dao;

import com.example.entry.ums_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

@Repository
public class dao1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    private ReentrantLock reentrantLock=new ReentrantLock();
    private int count;
    private Object object=new Object();
    private List<ums_role>list=new ArrayList<>();
   // @Async
    public List<ums_role> method1(){
            //reentrantLock.lock();
            list = jdbcTemplate.query("select * from ums_role", new BeanPropertyRowMapper<>(ums_role.class));
           // reentrantLock.unlock();
            return list;
    }
    public String testRedis(){
        //redisTemplate.opsForValue().set("B","b",10, TimeUnit.SECONDS);
        Boolean bool=redisTemplate.opsForValue().setIfAbsent("lock","lock");
        //redisTemplate.opsForValue().setIfPresent()
        if(bool){
            System.out.println(count++);
        }
        redisTemplate.delete("lock");
        return bool.toString();
    }
}
