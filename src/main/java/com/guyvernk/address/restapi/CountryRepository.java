package com.guyvernk.address.restapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountriesEntity,Integer>{
    CountriesEntity findByCountryId(int countryId);
}
