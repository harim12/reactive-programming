package com.rimHassani.reactiveprogramming.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private BookInfo bookinfo;
    private List<Review> reviews;
}
