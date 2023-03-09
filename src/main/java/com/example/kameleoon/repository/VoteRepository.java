package com.example.kameleoon.repository;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.User;
import com.example.kameleoon.model.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    Optional<Vote> findByUserAndQuote(User user, Quote quote);

    List<Vote> findAllByQuoteIdOrderByRegistered(Long id);

}