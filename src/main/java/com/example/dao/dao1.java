package com.example.dao;

import com.example.entry.ums_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

@Repository
public class dao1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    private int count;
    private Object object=new Object();
    private List<ums_role>list=new ArrayList<>();

    public List<ums_role> method1(){
        lock.writeLock().lock();
        //synchronized (object) {
            list = jdbcTemplate.query("select * from ums_role", new BeanPropertyRowMapper<>(ums_role.class));
            System.out.println(count++);
            lock.writeLock().unlock();
        //}
        return list;
    }
}
