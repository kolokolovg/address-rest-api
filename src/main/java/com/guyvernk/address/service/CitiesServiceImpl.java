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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service("citiesData")
@Repository
@Transactional
public class CitiesServiceImpl implements CitiesService {
    final Logger logger = LoggerFactory.getLogger(CitiesService.class);
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(readOnly = true)
    public List<CitiesEntity> findById(int id){
        List<CitiesEntity> ret = new ArrayList<CitiesEntity>();
        CitiesEntity res = null;
        try {
            res = (CitiesEntity) entityManager
                    .createQuery("select c from CitiesEntity c where c.id=" + id).getSingleResult();
        } catch (NoResultException ex){
            ex.printStackTrace();
        }

        finally {
            ret.add(res);
        }
        return ret;
    }

    @Transactional(readOnly = true)
    public List<CitiesEntity> findByTitleTop5(String titleRu) {
        List<CitiesEntity> result = findByTitleLimited(titleRu, 5);
        return result;
    }
    @Transactional(readOnly = true)
    public List<CitiesEntity> findByTitleLimited(String titleRU, int size) {
        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder =
                fullTextEntityManager.getSearchFactory().buildQueryBuilder()
                                     .forEntity(CitiesEntity.class).get();
        org.apache.lucene.search.Query query =
                queryBuilder
                        .keyword()
                        .wildcard()
                        .onField("title")
                        .matching(titleRU + "*")
                        .createQuery();
        org.hibernate.search.jpa.FullTextQuery jpaQuery =
                fullTextEntityManager.createFullTextQuery(query, CitiesEntity.class);
        if (size > 0 && size < 16) {
            jpaQuery.setMaxResults(size);
        } else {
            jpaQuery.setMaxResults(5);
        }

        List<CitiesEntity> result = jpaQuery.getResultList();
        return result;
    }
}
