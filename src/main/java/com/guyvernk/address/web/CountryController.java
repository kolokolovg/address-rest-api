package com.guyvernk.address.web;

import com.guyvernk.address.model.CountriesEntity;
import com.guyvernk.address.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "/country")
public class CountryController {
//       final Logger logger = LoggerFactory.getLogger(CityController.class);
    @Autowired
    private CountryService countryData;

    @RequestMapping(value = "/find/{name}",method =RequestMethod.GET)
    @ResponseBody
    public Callable<Countries> findByName(@PathVariable final String name){
        return new Callable<Countries>() {
            @Override
            public Countries call() throws Exception {
                return new Countries(countryData.findByName(name));
            }
        };
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Callable<Countries> findById(@PathVariable final int id){
        return new Callable<Countries>() {
            @Override
            public Countries call() throws Exception {
                return new Countries(countryData.findById(id));
            }
        };
    }

}
