package com.example.mapper;
import com.example.entry.sale;
import com.example.entry.ums_role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SaleMapper {
    @Select("select * from ums_role")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "description",column = "description"),
            @Result(property = "admin_count",column = "admin_count"),
            @Result(property = "create_time",column = "create_time"),
            @Result(property = "status",column = "status"),
            @Result(property = "sort",column = "sort")
    })
    List<ums_role> getumsFromMybatis();
    @Select("select * from sale_final where BILL =#{BILL}")
    List<sale>getSaleFromMybatis(String BILL);
}
