package com.sagar.service;

import com.sagar.dao.CountryDao;
import com.sagar.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by SAGAR on 27/04/2017.
 */

@Service
@Qualifier("dummyData")
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public Collection<Country> getCountries(){
        return countryDao.getCountries();
    }

    public Country getCountryById(String id){
        return countryDao.getCountryById(id);
    }

    public Country removeCountryById(String id){
        return countryDao.removeCountryById(id);
    }

    public void updateCountryById(Country country){
        countryDao.updateCountryById(country);
    }

    public void insertCountry(Country country){
        countryDao.insertCountry(country);
    }
}
