package com.guyvernk.address.service;

import com.guyvernk.address.model.CountriesEntity;
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

    @Override
    public List<CountriesEntity> findByName(String name) {
        return (List<CountriesEntity>) entityManager
                .createQuery("select c from CountriesEntity c where c.title_ru like"+name+"%").getResultList();

    }
}
