package com.example.kameleoon.repository;

import com.example.kameleoon.model.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long>, PagingAndSortingRepository<Quote, Long> {

    /*@RestResource(rel = "by-rating", path = "by-rating")
    List<Quote> findByRatingIsGreaterThan(Integer rating);*/

}
