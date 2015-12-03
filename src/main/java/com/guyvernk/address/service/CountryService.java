package com.guyvernk.address.service;

import com.guyvernk.address.model.CountriesEntity;

import java.util.List;

public interface CountryService {
    List<CountriesEntity> findById(int id);
    List<CountriesEntity> findByName(String name);
}
