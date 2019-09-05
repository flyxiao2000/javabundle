package com.xcloud.demo.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.xcloud.demo.domain.CommonResp;
import com.xcloud.demo.domain.Section;
import com.xcloud.demo.service.CityService;

import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xcloud.demo.domain.City;

@RestController
@RequestMapping(value = "/v1/demo")
public class DemoController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private ArrayList<City> cityList = new ArrayList<>();
    private Map<Long, City> cityMap = new HashMap<>();

    @Autowired
    private CityService cityService;

    public DemoController() {
        LOG.info("construct DemoController");
      //  cityList.add(new City(1L, 20, "shanghai"));
       // cityList.add(new City(2L, 22, "beijing"));
       // cityList.add(new City(3L, 22, "nanjing"));

        for (City c : cityList) {
            cityMap.put(c.getId(), c);
        }
    }

    @RequestMapping(value = "/testlog/{id}", method = RequestMethod.GET)
    public String testLog(@PathVariable String id) {
        LOG.debug("debug level log");
        LOG.info("info level log");
        LOG.warn("warn level log");
        LOG.error("error level log");

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
        return cityMap.get(id);
    }

    @RequestMapping(value = "/cities", method = RequestMethod.POST)
    public CommonResp postCity(@RequestBody City city) {
        cityMap.put(city.getId(), city);
        int a = cityService.insert(city);
        LOG.info("ccccc {} {}",a,city.getUserID());
        return new CommonResp(a, "success");
    }

}
