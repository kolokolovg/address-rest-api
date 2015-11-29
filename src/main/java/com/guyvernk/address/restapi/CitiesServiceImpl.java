package com.guyvernk.address.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("citiesData")
@Repository
@Transactional
public class CitiesServiceImpl implements CitiesService{
    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CitiesEntity> findByTitleRu(String titleRu) {
        return cityRepository.findByTitleRu(titleRu);
    }
}
