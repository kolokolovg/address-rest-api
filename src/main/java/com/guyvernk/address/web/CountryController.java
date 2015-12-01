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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Callable<CountriesEntity> findById(@PathVariable final int id){
        return new Callable<CountriesEntity>() {
            @Override
            public CountriesEntity call() throws Exception {
                return countryData.findById(id);
            }
        };
    }
}
