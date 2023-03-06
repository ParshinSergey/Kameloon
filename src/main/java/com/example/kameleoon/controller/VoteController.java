package com.example.kameleoon.controller;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.Vote;
import com.example.kameleoon.repository.QuoteRepository;
import com.example.kameleoon.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/quotes", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {

    VoteRepository voteRepository;
    QuoteRepository quoteRepository;

    public VoteController(VoteRepository voteRepository, QuoteRepository quoteRepository) {
        this.voteRepository = voteRepository;
        this.quoteRepository = quoteRepository;
    }

    @PostMapping(value = "/{quoteId}/votes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> createVote(@PathVariable Long quoteId, @RequestBody Vote vote){

        Quote quote = quoteRepository.findById(quoteId).orElseThrow();
        Integer rating = quote.getRating();
        quote.setRating(vote.isStatus() ? rating + 1 : rating - 1);
        vote.setQuote(quoteRepository.save(quote));
        Vote savedVote = voteRepository.save(vote);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/votes/{voteId}")
                .buildAndExpand(savedVote.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(savedVote);

    }


}
