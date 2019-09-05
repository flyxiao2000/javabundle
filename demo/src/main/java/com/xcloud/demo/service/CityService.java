package com.xcloud.demo.service;

import com.xcloud.demo.domain.City;

import java.util.List;

public interface CityService {
    City findCityByID(Long id);
    int insert(City city);
    List<City> findAll();
}
