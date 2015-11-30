package com.guyvernk.address.restapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<CitiesEntity,Integer> {
    List<CitiesEntity> findByTitleRu(String titleRu);
    List<CitiesEntity> findByTitleRuContaining(String titleRu);
    List<CitiesEntity> findFirst5ByTitleRuContaining(String titleRu);

 /*   @Query("select * from _cities c where c.titleRU like %:name% limit ?:limit")
    List<CitiesEntity> findByNameLimited(@Param("name") String name,
                                         @Param("limit") Integer limit);
*/

}
