package com.guyvernk.address.service;

import com.guyvernk.address.model.CitiesEntity;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("citiesData")
@Repository
@Transactional
public class CitiesServiceImpl implements CitiesService {
    final Logger logger = LoggerFactory.getLogger(CitiesService.class);
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(readOnly = true)
    public CitiesEntity findById(int id) {

        return null;
    }

    @Transactional(readOnly = true)
    public List<CitiesEntity>findByTitleRu(String titleRu) {
       FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder =
                fullTextEntityManager.getSearchFactory().buildQueryBuilder()
                .forEntity(CitiesEntity.class).get();
        org.apache.lucene.search.Query query=
                queryBuilder
                .keyword()
                .wildcard()
                .onField("title")
                .matching(titleRu+"*")
                .createQuery();
        org.hibernate.search.jpa.FullTextQuery jpaQuery =
                fullTextEntityManager.createFullTextQuery(query,CitiesEntity.class);
        List<CitiesEntity> result = jpaQuery.getResultList();
        return  result;
    }

    @Transactional(readOnly = true)
    public List<CitiesEntity> findByName(String titleRu) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<CitiesEntity> findByNameLimited(String titleRU, int size) {
        return null;
    }
}
