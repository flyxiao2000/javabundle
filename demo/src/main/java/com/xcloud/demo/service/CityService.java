package com.xcloud.demo.service;

import com.xcloud.demo.domain.City;

public interface CityService {
    City findCityByID(Long id);
    int insert(City city);
}
