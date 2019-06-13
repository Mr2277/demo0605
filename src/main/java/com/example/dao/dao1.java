package com.example.dao;

import com.example.entry.ums_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
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
    @Autowired
    @Qualifier("MyRedisTemplate")
    private RedisTemplate myRedisTemplate;
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
    @Async
    public Future<List<ums_role>> findmethod7(){
        list=jdbcTemplate.query("select * from ums_role", new BeanPropertyRowMapper<>(ums_role.class));
        return new AsyncResult<List<ums_role>>(list);
    }
    public String selectFromRedis(){
        String sql="select * from ums_role";
        if(!myRedisTemplate.hasKey(sql)){
             list=jdbcTemplate.query("select * from ums_role", new BeanPropertyRowMapper<>(ums_role.class));
             myRedisTemplate.opsForList().rightPushAll(sql,list);
        }
        return null;
    }
    public List<ums_role> readFromRedis(){
        String key="select * from ums_role";
        //List<ums_role>list= (List<ums_role>) myRedisTemplate.opsForValue().get(key);
        List<ums_role>list=myRedisTemplate.opsForList().range(key,0,-1);
        return list;
    }
}
