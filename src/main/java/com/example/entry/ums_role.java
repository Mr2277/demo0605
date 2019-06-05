package com.example.entry;

import java.math.BigInteger;
import java.util.Date;

public class ums_role {
    private BigInteger id;
    private String name;
    private String description;
    private Integer admin_count;
    private Date create_time;
    private Integer status;
    private Integer sort;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdmin_count() {
        return admin_count;
    }

    public void setAdmin_count(Integer admin_count) {
        this.admin_count = admin_count;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
