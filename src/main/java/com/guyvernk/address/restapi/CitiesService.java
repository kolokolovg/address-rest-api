package com.guyvernk.address.restapi;

import java.util.List;

public interface CitiesService {
    List<CitiesEntity> findByTitleRu(String titleRu);
}
