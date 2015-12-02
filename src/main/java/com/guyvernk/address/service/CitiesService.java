package com.guyvernk.address.service;

import com.guyvernk.address.model.CitiesEntity;

import java.util.List;

public interface CitiesService {
    CitiesEntity findById(int id);
    List<CitiesEntity> findByTitleTop5(String titleRu);
    List<CitiesEntity> findByTitleLimited(String titleRU, int size);
}
