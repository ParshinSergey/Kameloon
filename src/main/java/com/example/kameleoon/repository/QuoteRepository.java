package com.example.kameleoon.repository;

import com.example.kameleoon.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findTop10ByOrderByRatingDesc();
    List<Quote> findTop10ByOrderByRating();

}
