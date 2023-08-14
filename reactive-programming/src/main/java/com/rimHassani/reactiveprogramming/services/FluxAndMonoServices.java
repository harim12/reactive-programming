package com.rimHassani.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoServices {
    public Flux<String> fruitesFlux(){
        return Flux.fromIterable(List.of("apples","bananas","mango")).log();
    }

    public Flux<String> fruitesFluxMap(){
        return Flux.fromIterable(List.of("apples","bananas","mango"))
                .map(String::toUpperCase)
                .log();
    }

    public Mono<String> fruitMono(){
        return Mono.just("apples").log();
    }

    public static void main(String args[]){
        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

        fluxAndMonoServices.fruitesFlux()
                .subscribe(s-> System.out.println("s=>"+s));


        fluxAndMonoServices.fruitMono()
                .subscribe(s-> System.out.println("mono "+s));
    }
}
