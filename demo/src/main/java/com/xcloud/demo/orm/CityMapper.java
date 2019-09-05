package com.xcloud.demo.orm;

import org.apache.ibatis.annotations.Param;

import com.xcloud.demo.domain.City;
import java.util.List;

public interface CityMapper {
    City findByID(Long id);
    int insert(City record);
    List<City> findAll();
}
