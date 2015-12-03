package com.guyvernk.address.service;

import com.guyvernk.address.model.CountriesEntity;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("countryData")
@Repository
@Transactional
public class CountryServiceImpl implements CountryService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<CountriesEntity> findById(int id) {
        return (List<CountriesEntity>) entityManager
                .createQuery("select c from CountriesEntity c where c.id=" + id).getResultList();
    }

    @Transactional(readOnly = true)
    public List<CountriesEntity> findByName(String name) {
        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder =
                fullTextEntityManager.getSearchFactory().buildQueryBuilder()
                                     .forEntity(CountriesEntity.class).get();
        org.apache.lucene.search.Query query =
                queryBuilder
                        .keyword()
                        .wildcard()
                        .onField("title")
                        .matching(name + "*")
                        .createQuery();
        org.hibernate.search.jpa.FullTextQuery jpaQuery =
                fullTextEntityManager.createFullTextQuery(query, CountriesEntity.class);
        List<CountriesEntity> result = jpaQuery.getResultList();
        return result;
    }
}
