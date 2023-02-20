package com.example.kameleoon.repository;

import com.example.kameleoon.model.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long> {

}
