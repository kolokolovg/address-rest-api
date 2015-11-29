package com.guyvernk.address.restapi;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class TestJpa {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/root-context.xml");
        ctx.refresh();

        CitiesService citiesService = ctx.getBean("citiesData",CitiesService.class);
        String search = "Moscow";
        listResult(citiesService.findByTitleRu(search));

    }

    private static void listResult(List<CitiesEntity> cities) {
        for(CitiesEntity city: cities){
            System.out.println(city);
        }
    }
}
