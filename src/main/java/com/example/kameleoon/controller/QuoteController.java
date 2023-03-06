package com.example.kameleoon.controller;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.Vote;
import com.example.kameleoon.repository.QuoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/api/quotes", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuoteController {

    QuoteRepository quoteRepository;

    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Quote> getById(@PathVariable long id){
        try {
            Quote quote = quoteRepository.findById(id).orElseThrow();
            return new ResponseEntity<>(quote, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Quote> create(@RequestBody Quote quote){

        // quote.setUser(authorityUser);
        Quote savedQuote = quoteRepository.save(quote);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/quotes/{quoteId}")
                .buildAndExpand(savedQuote.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(savedQuote);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody Quote quote){

        // here must be check user_id
        if (quote.getId() != id) {
            throw new RuntimeException();
        } else quoteRepository.save(quote);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        quoteRepository.deleteById(id);
    }

    @GetMapping(value = "/by-rating")
    public Page<Quote> findDown10(){
        return quoteRepository.findAll(PageRequest.of(0, 10, Sort.by("rating").descending()));
    }

    @GetMapping(value = "/by-rating-desc")
    public List<Quote> findTop10() {
        return StreamSupport.stream(quoteRepository.findAll().spliterator(), false)
                .sorted(Comparator.comparing(Quote::getRating))
                .limit(10)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/random")
    public Quote randomQuote() {
        long qty = quoteRepository.count();
        int index = (int)ThreadLocalRandom.current().nextLong(qty);
        Page<Quote> questionPage = quoteRepository.findAll(PageRequest.of(index, 1));
        Quote quote = null;
        if (questionPage.hasContent()) {
            quote = questionPage.getContent().get(0);
        }
        return quote;
    }


}
