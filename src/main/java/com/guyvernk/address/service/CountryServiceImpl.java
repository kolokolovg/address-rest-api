package com.guyvernk.address.service;

import com.guyvernk.address.model.CountriesEntity;
import com.guyvernk.address.service.CountryService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("countryData")
@Repository
@Transactional
public class CountryServiceImpl implements CountryService {
    @Transactional(readOnly = true)
    public CountriesEntity findById(int id) {
        return null;
    }
}
