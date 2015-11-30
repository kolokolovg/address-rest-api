package com.guyvernk.address.restapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<CitiesEntity,Integer> {
    List<CitiesEntity> findByTitleRu(String titleRu);
    List<CitiesEntity> findByTitleRuContaining(String titleRu);
    List<CitiesEntity> findFirst5ByTitleRuContaining(String titleRu);

   @Query(value ="select * from _cities where title_ru like %?1% limit ?2", nativeQuery = true)
    List<CitiesEntity> findByNameLimited(String name,int limit);

}
