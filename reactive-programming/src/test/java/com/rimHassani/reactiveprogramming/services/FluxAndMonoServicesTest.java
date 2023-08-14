package com.rimHassani.reactiveprogramming.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServicesTest {


    private FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void fruitesFlux() {
        var fruitsFlux = fluxAndMonoServices.fruitesFlux();
        StepVerifier.create(fruitsFlux)
                .expectNext("apples","bananas","mango")
                .verifyComplete();
    }

    @Test
    void fruitesFluxMap() {
        var fruitsFluxMap = fluxAndMonoServices.fruitesFluxMap();
        StepVerifier.create(fruitsFluxMap)
                .expectNext("APPLES","BANANAS","MANGO")
                .verifyComplete();
    }
    @Test
    void fruitesFluxFilter() {
        var fruitsFlux = fluxAndMonoServices.fruitesFluxFilter(6);
        StepVerifier.create(fruitsFlux)
                .expectNext("bananas")
                .verifyComplete();
    }

    @Test
    void fruitesFluxFilterMap() {
        var fruitsFluxFilterMap = fluxAndMonoServices.fruitesFluxFilterMap(6);
        StepVerifier.create(fruitsFluxFilterMap)
                .expectNext("BANANAS")
                .verifyComplete();
    }


    @Test
    void fruitMono() {
    }
}