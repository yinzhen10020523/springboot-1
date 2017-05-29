package com.sagar;

import com.sagar.entity.Country;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by SAGAR on 29/05/2017.
 */
@RepositoryRestResource(collectionResourceRel = "country",path = "country")
@Qualifier("MongoDb")
public interface CountryMongoRepository extends MongoRepository<Country,String> {

    List<Country> findByCountryCode(@Param("code") String code);

}
