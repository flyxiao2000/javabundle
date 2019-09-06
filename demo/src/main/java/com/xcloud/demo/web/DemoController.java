package com.xcloud.demo.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.xcloud.demo.config.BookProperties;
import com.xcloud.demo.domain.CommonResp;
import com.xcloud.demo.domain.Section;
import com.xcloud.demo.service.CityService;

import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.*;

import com.xcloud.demo.domain.City;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/v1/demo")
@Slf4j
public class DemoController {
    //private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    //private ArrayList<City> cityList = new ArrayList<>();
    // private Map<Long, City> cityMap = new HashMap<>();

    @Autowired
    private CityService cityService;
    @Autowired
    private BookProperties bookProperties;

    @PostConstruct
    public void sayMyScope() {
        System.out.println("hello,i am MyScopeTest1, my scope is ");
    }

    public DemoController() {
        log.info("construct DemoController");
        City c = City.builder()
                .id(1L)
                .age(20)
                .name("hello")
                .userID(0)
                .build();
        log.info(c.toString());
        log.info("city hashcode {}", c.hashCode());
//        cityList.add(c);
//        cityList.add(new City(1L, 20, "shanghai"));
//        cityList.add(new City(2L, 22, "beijing"));
//        cityList.add(new City(3L, 22, "nanjing"));
//
//        for (City cc : cityList) {
//            cityMap.put(cc.getId(), cc);
//        }
    }

    @RequestMapping(value = "/testlog/{id}", method = RequestMethod.GET)
    public String testLog(@PathVariable String id) {
        log.debug("debug level log");
        log.info("info level log");
        log.warn("warn level log");
        log.error("error level log");

        return "Hello, I am demo! " + id;
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<City> getCityList(@RequestParam(value = "id", required = false, defaultValue = "0") Long id) {
        if (id != 0L) {
            ArrayList<City> cityList = new ArrayList<>();
            City c = cityService.findCityByID(id);
            if (c != null) {
                cityList.add(c);
            }
            return cityList;
        }
        return cityService.findAll();
    }

    @RequestMapping(value = "/cities/{id}", method = RequestMethod.GET)
    public City getCity(@PathVariable Long id) {
        log.info("bookProperties {}", bookProperties.toString());
        return cityService.findCityByID(id);
    }

    @RequestMapping(value = "/cities", method = RequestMethod.POST)
    public CommonResp postCity(@RequestBody City city) {
        int a = cityService.insert(city);
        log.info("ccccc {} {}", a, city.getUserID());
        return new CommonResp(a, "success");
    }

}
