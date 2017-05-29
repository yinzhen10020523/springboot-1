# springboot
A simple spring-boot REST application

Revision 1. Application uses dummy country data as REST service using spring boot web MVC

Revision 2. Used Mongo db over Spring REST. Ref -https://spring.io/guides/gs/accessing-mongodb-data-rest/

http://localhost:8080/country/search/findByCountryCode?code=US
{
  "_embedded" : {
    "country" : [ {
      "countryCode" : "US",
      "name" : "USA",
      "capital" : "Washington",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/country/592c5d735138fc34f0c88867"
        },
        "country" : {
          "href" : "http://localhost:8080/country/592c5d735138fc34f0c88867"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/country/search/findByCountryCode?code=US"
    }
  }
}

TODO
1) Swagger to build REST API
