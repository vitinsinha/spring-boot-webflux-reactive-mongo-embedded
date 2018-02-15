package com.spring.example.repositories;

import com.spring.example.models.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
    Flux<Person> findByName(String name);
}
