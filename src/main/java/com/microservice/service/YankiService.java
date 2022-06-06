package com.microservice.service;

import com.microservice.Dto.YankiResponse;
import com.microservice.model.Yanki;
import com.microservice.repository.YankiRepository;
import com.microservice.service.impl.YankiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class YankiService implements YankiServiceImpl {

    @Autowired
    YankiRepository yankiRepository;

    @Override
    public Flux<YankiResponse> getAllYanki() {
        return yankiRepository.findAll().map(yanki -> YankiResponse.builder().amount(yanki.getAmount())
                .identityDocument(yanki.getIdentityDocument())
                .phoneNumber(yanki.getPhoneNumber())
                .build());
    }

    @Override
    public Flux<YankiResponse> getPhoneYanki(String phoneNumber) {
        return yankiRepository.findAll().filter(yanki -> yanki.getPhoneNumber().equals(phoneNumber))
                .map(yanki -> YankiResponse.builder().amount(yanki.getAmount())
                .identityDocument(yanki.getIdentityDocument())
                .phoneNumber(yanki.getPhoneNumber())
                .build());
    }

    @Override
    public Mono<Yanki> createYanki(Yanki yanki) {
        return yankiRepository.save(yanki);
    }


}