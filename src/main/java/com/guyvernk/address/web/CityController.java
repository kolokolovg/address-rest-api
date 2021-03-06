package com.guyvernk.address.web;

import com.guyvernk.address.service.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "/city")
public class CityController {
    //    final Logger logger = LoggerFactory.getLogger(CityController.class);
    @Autowired
    private CitiesService citiesData;

    @RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Callable <Cities> findByName(@PathVariable final String name) {
        return new Callable<Cities>() {
            @Override
            public Cities call() throws Exception {
                return new Cities(citiesData.findByTitleTop5(name));
            }
        };
    }

    @RequestMapping(value = "/find/{name}/{size}", method = RequestMethod.GET)
    @ResponseBody
    public Callable<Cities> findByNameLimited(@PathVariable final String name,
                                              @PathVariable final int size) {
        return new Callable<Cities>() {
            @Override
            public Cities call() throws Exception {
               return new Cities(citiesData.findByTitleLimited(name, size));
            }
        };

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Callable<Cities> findById(@PathVariable final int id) {
        return new Callable<Cities>() {
            @Override
            public Cities call() throws Exception {
                return new Cities(citiesData.findById(id));
            }
        };
    }
}
