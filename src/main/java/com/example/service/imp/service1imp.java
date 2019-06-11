package com.example.service.imp;

import com.example.dao.dao1;
import com.example.entry.ums_role;
import com.example.service.service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class service1imp implements service1 {
    @Autowired
    private dao1 d1;
    @Override
    public List<ums_role> findAll() {

        return d1.method1();
    }

    @Override
    public String testRedis() {
        return d1.testRedis();
    }
}
