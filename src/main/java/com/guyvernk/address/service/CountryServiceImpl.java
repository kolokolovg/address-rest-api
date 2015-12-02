package com.guyvernk.address.service;

import com.guyvernk.address.model.CountriesEntity;
import com.guyvernk.address.service.CountryService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("countryData")
@Repository
@Transactional
public class CountryServiceImpl implements CountryService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public CountriesEntity findById(int id) {
        return (CountriesEntity) entityManager
                .createQuery("select c from CountriesEntity c where c.id=" + id).getSingleResult();
    }
}
