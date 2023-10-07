package com.rimHassani.reactiveprogramming.controller;

import com.rimHassani.reactiveprogramming.domain.BookInfo;
import com.rimHassani.reactiveprogramming.services.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController // Use @RestController instead of @Controller
@CrossOrigin("*")
public class BookController {
    @Autowired
    private BookInfoService bookInfoService;

    @MessageMapping("/books")
    @SendTo("/topic/books")
    public Flux<BookInfo> getBooks() {
        return bookInfoService.getBooks();
    }
}
