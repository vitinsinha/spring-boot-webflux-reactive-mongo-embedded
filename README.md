# Spring Boot Webflux Reactive Mongo Embedded

This is a sample application that shows how to build a web application using
 - Spring Boot 2
 - Spring Webflux
    - Annotation based programming model
    - Functional, Java 8 lambda style, programming model
    - Error handling
 - Spring Reactive Data MongoDb (Embedded)
 - Spring Security Reactive Webflux
 
 
<br/>
Please see the following pages for more details
  
  - Spring Web Reactive <br/><a>http://docs.spring.io/spring-framework/docs/5.0.0.M1/spring-framework-reference/html/web-reactive.html</a>
  - Spring Data Reactive <br/><a>https://spring.io/blog/2016/11/28/going-reactive-with-spring-data</a>
  - Spring Functional Web Framework <br/><a>https://spring.io/blog/2016/09/22/new-in-spring-5-functional-web-framework</a>

## Running the application

Run using the gradle wrapper included

```
./gradlew bootRun
```

And then go to http://localhost:8080 to test the API's.


## cURL Commands

You can try the following API's once the server is running.

GET __/test__

``` curl http://localhost:8080/test -v -u user:password```

GET __/person__

``` curl http://localhost:8080/person -v -u user:password```

GET __/person/{id}__

``` curl http://localhost:8080/person/{id} -v -u user:password```

POST __/person__

``` curl -X POST -d '{"name":"John Doe","age":20,"id":1}' -H "Content-Type: application/json" http://localhost:8080/person -v -u user:password```

Note: If you post the same id again, you will see an error response.
