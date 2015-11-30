package com.guyvernk.address.restapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/city")
public class CityController {
//    final Logger logger = LoggerFactory.getLogger(CityController.class);
    @Autowired
    private CitiesService citiesData;

    @RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Cities findByName(@PathVariable String name){
    return new Cities(citiesData.findByName(name));
    }
    @RequestMapping(value = "/find/{name}/{size}", method = RequestMethod.GET)
    @ResponseBody
    public Cities findByNameLimited(@PathVariable String name,@PathVariable int size){
        return new Cities(citiesData.findByNameLimited(name, size));
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CitiesEntity findById(@PathVariable int id){
        return citiesData.findById(id);
    }
}
