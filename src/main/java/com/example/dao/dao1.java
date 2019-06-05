package com.example.dao;

import com.example.entry.ums_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class dao1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<ums_role> method1(){
        List<ums_role>list=jdbcTemplate.query("select * from ums_role",new BeanPropertyRowMapper<>(ums_role.class));
        return list;
    }
}
