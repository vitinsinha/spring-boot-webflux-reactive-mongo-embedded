package com.spring.example.controllers;

import com.spring.example.models.Person;
import com.spring.example.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutesConfiguration {

    private static final Logger log = LoggerFactory.getLogger(RoutesConfiguration.class);

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    RouterFunction<?> routes(PersonRepository personRepository) {
        return route(GET("/person/{id}"), request -> ok().body(personRepository.findById(request.pathVariable("id")), Person.class))
                .andRoute(POST("/person"),
                        request -> {
                            return personRepository.insert(request.bodyToMono(Person.class))
                                    .next()
                                    .flatMap(s -> ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just("Post Successful"), String.class))
                                    .onErrorResume(Exception.class, e -> {
                                        log.error("Exception: ", e);
                                        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .body(Mono.just("Exception occurred while inserting data:\n" + e.getMessage()), String.class); });

                        })
                //Just for testing another route
                .andRoute(GET("/test"), request -> ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just("test"), String.class));
    }
}
