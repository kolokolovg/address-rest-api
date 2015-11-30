package com.guyvernk.address.restapi;

import java.util.List;

public interface CitiesService {
    List<CitiesEntity> findByTitleRu(String titleRu);
    List<CitiesEntity> findByName(String titleRu);
    List<CitiesEntity> findByNameLimited(String titleRU, int size);
}
