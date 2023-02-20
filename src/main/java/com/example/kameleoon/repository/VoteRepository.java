package com.example.kameleoon.repository;

import com.example.kameleoon.model.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {

}