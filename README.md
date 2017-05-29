# springboot
A simple spring-boot REST application

Revision 1. Application uses dummy country data as REST service using spring boot web MVC

Revision 2. Used Mongo db over Spring REST. Ref -https://spring.io/guides/gs/accessing-mongodb-data-rest/

http://localhost:8080/country/search/findByCountryCode?code=US <br/>
{<br/>
  "_embedded" : {<br/>
    "country" : [ {<br/>
      "countryCode" : "US",<br/>
      "name" : "USA",<br/>
      "capital" : "Washington",<br/>
      "_links" : {<br/>
        "self" : {<br/>
          "href" : "http://localhost:8080/country/592c5d735138fc34f0c88867"<br/>
        },<br/>
        "country" : {<br/>
          "href" : "http://localhost:8080/country/592c5d735138fc34f0c88867"<br/>
        }<br/>
      }<br/>
    } ]<br/>
  },<br/>
  "_links" : {<br/>
    "self" : {<br/>
      "href" : "http://localhost:8080/country/search/findByCountryCode?code=US"<br/>
    }<br/>
  }<br/>
}<br/>

TODO
1) Swagger to build REST API
