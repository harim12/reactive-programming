package com.rimHassani.reactiveprogramming.services;

import com.rimHassani.reactiveprogramming.domain.BookInfo;
import com.rimHassani.reactiveprogramming.repository.BookInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BookInfoService {
    @Autowired
    private BookInfoRepository bookInfoRepository;

    public Flux<BookInfo> getBooks(){

        return Flux.fromIterable(bookInfoRepository.findAll());

    }


}
