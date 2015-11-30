package com.guyvernk.address.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("countryData")
@Repository
@Transactional
public class CountryServiceImpl implements CountryService{
    @Autowired
    CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public CountriesEntity findById(int id) {
        return countryRepository.findByCountryId(id);
    }
}
