package com.rimHassani.reactiveprogramming.services;

import com.rimHassani.reactiveprogramming.domain.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MyWebSocketHandler implements WebSocketHandler {

    @Autowired
    private BookInfoService bookInfoService;

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<BookInfo> bookInfoFlux = bookInfoService.getBooks();

        Flux<String> messageFlux = bookInfoFlux.map(BookInfo::toString);

        return session.send(
                messageFlux.map(session::textMessage)
        );
    }
}
