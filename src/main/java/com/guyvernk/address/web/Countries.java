package com.guyvernk.address.web;

import com.guyvernk.address.model.CountriesEntity;

import java.io.Serializable;
import java.util.List;

public class Countries implements Serializable {
    private List<CountriesEntity> countries;

    public Countries() {
    }

    public Countries(List<CountriesEntity> countries) {
        this.countries = countries;
    }

    public List<CountriesEntity> getCountries() {
        return countries;
    }
    public void setCountries(List<CountriesEntity> countries) {
        this.countries = countries;
    }
}
