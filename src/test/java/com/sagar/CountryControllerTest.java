package com.sagar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by SAGAR on 27/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CountryControllerTest {

    @Autowired
    private MockMvc mock;

    @Test
    public void testHome() throws Exception{
        this.mock.perform(get("/countries"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("capital")));
    }

    @Test
    public void testCountryUK() throws Exception{
        this.mock.perform(get("/countries/UK"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("capital", equalTo("London")))
                .andExpect(jsonPath("name", equalTo("United Kingdom")));
    }

    @Test
    public void testInsertCountryFR() throws Exception{
        String country = "{\"id\":\"FR\",\"name\":\"France\",\"capital\":\"Paris\"}";
        this.mock.perform(post("/countries").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON).content(country))
                .andExpect(status().isOk());
    }

    @Test
    public void testBadInsertCountryGER() throws Exception{
        String country = "{\"countryCode\":\"GR\",\"name\":\"France\",\"capital\":\"Paris\"}";
        this.mock.perform(post("/countries").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON).content(country))
                .andExpect(status().isBadRequest());
    }

}
