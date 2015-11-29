package com.guyvernk.address.restapi;

import java.io.Serializable;
import java.util.List;

public class Cities implements Serializable {
    private List<CitiesEntity> cities;

    public Cities() {
    }

    public Cities(List<CitiesEntity> cities) {
        this.cities = cities;
    }

    public List<CitiesEntity> getCities() {
        return cities;
    }

    public void setCities(List<CitiesEntity> cities) {
        this.cities = cities;
    }
}
