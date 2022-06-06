package com.microservice.repository;

import com.microservice.model.Yanki;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YankiRepository extends ReactiveCrudRepository<Yanki, String> {
}
