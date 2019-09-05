package com.xcloud.demo.orm;

import org.apache.ibatis.annotations.Param;

import com.xcloud.demo.domain.City;

public interface CityMapper {
    City findByID(@Param("id") Long id);
    int insert(@Param("city") City record);
}
