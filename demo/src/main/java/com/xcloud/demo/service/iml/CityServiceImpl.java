package com.xcloud.demo.service.iml;

import com.xcloud.demo.orm.CityMapper;
import com.xcloud.demo.domain.City;
import com.xcloud.demo.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    public City findCityByID(Long id) {
        return cityMapper.findByID(id);
    }

}
