package com.sagar.entity;

/**
 * Created by SAGAR on 27/04/2017.
 */
public class Country {
    private String id;
    private String name;
    private String capital;

    public Country(String id, String name, String capital) {
        this.id = id;
        this.name = name;
        this.capital = capital;
    }

    public  Country(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}

