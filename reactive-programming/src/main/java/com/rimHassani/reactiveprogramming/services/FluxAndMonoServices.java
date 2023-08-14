package com.rimHassani.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FluxAndMonoServices {
    public Flux<String> fruitesFlux(){
        return Flux.fromIterable(List.of("apples","bananas","mango")).log();
    }

    public Flux<String> fruitesFluxMap(){
        return Flux.fromIterable(List.of("apples","bananas","mango"))
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> fruitesFluxFilter(int number){
        return Flux.fromIterable(List.of("apples","bananas","mango"))
                .filter(s->s.length()>number)
                .log();
    }
    public Flux<String> fruitesFluxFilterMap(int number){
        return Flux.fromIterable(List.of("apples","bananas","mango"))
                .filter(s->s.length()>number)
                .map(String::toUpperCase)
                .log();
    }
    public Flux<String> fruitesFluxFlatMap(){
        return Flux.fromIterable(List.of("apples","bananas","mango"))
                .flatMap(s->Flux.just(s.split("")))
                .log();
    }
    public Flux<String> fruitesFluxFlatMapAsync(){
        return Flux.fromIterable(List.of("apples","bananas","mango"))
                .flatMap(s->Flux.just(s.split("")))
                .delayElements(
                        Duration.ofMillis(new Random().nextInt(1000))
                )
                .log();
    }
    public Flux<String> fruitesFluxTransform(int number){
        Function<Flux<String>,Flux<String>> filterData
                = data -> data.filter(s->s.length()>number);
        return Flux.fromIterable(List.of("apples","bananas","mango"))
                .transform(filterData)
                .log();
    }

    public Flux<String> fruitesFluxDefaultIfEmpty(int number){
        Function<Flux<String>,Flux<String>> filterData
                = data -> data.filter(s->s.length()>number);
        return Flux.fromIterable(List.of("apples","bananas","mango"))
                .transform(filterData)
                .defaultIfEmpty("default")
                .log();
    }


    public Mono<String> fruitMono(){
        return Mono.just("apples").log();
    }
    public Mono<List<String>> fruitMonoFlatMap(){
        return Mono.just("apples")
                .flatMap(s-> Mono.just(List.of(s.split(""))))
                .log();
    }


    public static void main(String args[]){
        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

        fluxAndMonoServices.fruitesFlux()
                .subscribe(s-> System.out.println("s=>"+s));


        fluxAndMonoServices.fruitMono()
                .subscribe(s-> System.out.println("mono "+s));
    }
}
