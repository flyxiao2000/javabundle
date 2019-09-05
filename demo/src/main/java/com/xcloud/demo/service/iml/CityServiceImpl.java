package com.xcloud.demo.service.iml;

import com.xcloud.demo.orm.CityMapper;
import com.xcloud.demo.domain.City;
import com.xcloud.demo.service.CityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityServiceImpl implements CityService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityMapper cityMapper;

    public City findCityByID(Long id) {
        return cityMapper.findByID(id);
    }

    public int insert(City city)  {
        try {
            return cityMapper.insert(city);
        } catch (Exception e) {
            String message = "创建任务失败 " + e.getMessage();
            LOG.error(message);
            return 22;
        }
    }

}
