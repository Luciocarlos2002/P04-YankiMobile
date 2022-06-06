package com.microservice.repository;

import com.microservice.model.YankiDeposit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YankiDepositRepository extends ReactiveCrudRepository<YankiDeposit, String> {
}
