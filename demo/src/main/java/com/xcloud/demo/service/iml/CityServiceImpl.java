package com.xcloud.demo.service.iml;

import com.xcloud.demo.config.BookProperties;
import com.xcloud.demo.orm.CityMapper;
import com.xcloud.demo.domain.City;
import com.xcloud.demo.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.extern.slf4j.*;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class CityServiceImpl implements CityService {
    // private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private BookProperties bookProperties;

    @PostConstruct
    void printBook() {
        log.info("bookProperties {} ", bookProperties.toString());
        bookProperties.setName("ggggggggggxxx-------------");
    }

    public City findCityByID(Long id) {
        return cityMapper.findByID(id);
    }

    public int insert(City city) {
        try {
            return cityMapper.insert(city);
        } catch (Exception e) {
            String message = "创建任务失败 " + e.getMessage();
            log.error(message);
            return 22;
        }
    }

    public List<City> findAll() {
        return cityMapper.findAll();
    }

}
