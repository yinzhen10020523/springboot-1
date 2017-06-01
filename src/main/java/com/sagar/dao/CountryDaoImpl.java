package com.sagar.dao;

import com.sagar.entity.Country;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SAGAR on 27/04/2017.
 */

@Repository
@Qualifier("dummyData")
public class CountryDaoImpl implements CountryDao {

    private static Map<String,Country>  countries;

    static{
        countries = new HashMap<String, Country>(){
            {
                put("UK", new Country("UK","United Kingdom","London"));
                put("IN", new Country("IN","India","New Delhi"));
                put("US", new Country("US","United States","New York"));
                put("JP", new Country("JP","Japan","Tokyo"));
            }
        };
    }

    @Override
    public Collection<Country> getCountries(){
        return countries.values();
    }

    @Override
    public Country getCountryById(String id){
        return countries.get(id);
    }

    @Override
    public Country removeCountryById(String id){
        return countries.remove(id);
    }

    @Override
    public void updateCountryById(Country country){
        Country c = countries.get(country.getId());
        c.setCapital(country.getCapital());
        c.setName(country.getName());
    }

    @Override
    public void insertCountry(Country country){
        countries.put(country.getId(),country);
    }

}
