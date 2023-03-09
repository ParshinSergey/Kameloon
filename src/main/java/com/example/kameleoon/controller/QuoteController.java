package com.example.kameleoon.controller;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.service.QuoteService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/quotes", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuoteController {

    QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> getById(@PathVariable long id){
        try {
            Quote quote = quoteService.getQuoteById(id);
            return new ResponseEntity<>(quote, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Quote> create(@RequestBody Quote quote){

        // quote.setUser(authorityUser);
        Quote savedQuote = quoteService.createQuote(quote);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/quotes/{quoteId}")
                .buildAndExpand(savedQuote.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(savedQuote);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody Quote quote) {

        // here must be check user_id
        quoteService.updateQuote(id, quote);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        quoteService.deleteById(id);
    }

    @GetMapping(value = "/by-rating")
    public Page<Quote> findFlop10(){
        return quoteService.findFlop10();
    }

    @GetMapping(value = "/by-rating-desc")
    public List<Quote> findTop10() {
        return quoteService.findTop10();
    }

    @GetMapping(value = "/random")
    public Quote randomQuote() {
        return quoteService.randomQuote();
    }

}
