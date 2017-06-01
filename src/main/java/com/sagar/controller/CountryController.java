package com.sagar.controller;

import com.sagar.entity.Country;
import com.sagar.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by SAGAR on 27/04/2017.
 */
@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Country> getCountries(){
        return service.getCountries();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Country getCountryById(@PathVariable("id") String id){
        if(id==null || id.isEmpty() || service.getCountryById(id) == null){
            throw new IllegalArgumentException("Country code is invalid");
        }
        return service.getCountryById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Country removeCountryById(@PathVariable("id") String id){
        return service.removeCountryById(id);
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public void updateCountryById(@Validated @RequestBody Country country){
        validateCountry(country);
        service.updateCountryById(country);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertCountry(@Validated @RequestBody  Country country){
       validateCountry(country);
       service.insertCountry(country);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    void handleInvalidRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    private void validateCountry(Country country) throws IllegalArgumentException{
        if(country.getId() == null || country.getName() == null || country.getCapital() == null){
            throw new IllegalArgumentException("Country details are invalid");
        }
    }
}
