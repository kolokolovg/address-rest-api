package com.guyvernk.address.restapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<CitiesEntity,Integer> {
    List<CitiesEntity> findByTitleRu(String titleRu);

}
