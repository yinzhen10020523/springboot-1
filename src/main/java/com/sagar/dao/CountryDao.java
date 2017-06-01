package com.sagar.dao;

import com.sagar.entity.Country;

import java.util.Collection;

/**
 * Created by SAGAR on 27/04/2017.
 */
public interface CountryDao {
    Collection<Country> getCountries();

    Country getCountryById(String id);

    Country removeCountryById(String id);

    void updateCountryById(Country country);

    void insertCountry(Country country);
}
