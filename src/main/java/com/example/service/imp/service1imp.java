package com.example.service.imp;

import com.example.entry.ums_role;
import com.example.service.service1;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class service1imp implements service1 {
    @Override
    public List<ums_role> findAll() {
        System.out.println("ser1");
        return null;
    }
}
