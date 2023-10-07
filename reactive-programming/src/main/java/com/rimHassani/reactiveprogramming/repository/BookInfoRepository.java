package com.rimHassani.reactiveprogramming.repository;

import com.rimHassani.reactiveprogramming.domain.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo,Integer> {
}
