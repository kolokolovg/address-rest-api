package com.guyvernk.address.utils;

import com.guyvernk.address.model.CitiesEntity;
import com.guyvernk.address.service.CitiesService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class CitiSearchTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/datasource-lite.xml");
        ctx.refresh();

        CitiesService citiesService = ctx.getBean("citiesData",CitiesService.class);
        List<CitiesEntity> res = citiesService.findByTitleRu("новгор");
        listCities(res);
    }
    private static void listCities(List<CitiesEntity> all) {
        System.out.println("");
        System.out.println("Listing cities: ");
        for (CitiesEntity contact : all) {
            System.out.println(contact);
            System.out.println();
        }
    }
}
