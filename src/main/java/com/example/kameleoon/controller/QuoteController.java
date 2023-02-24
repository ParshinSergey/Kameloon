package com.example.kameleoon.controller;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.repository.QuoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/quotes", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuoteController {

    QuoteRepository quoteRepository;

    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping(value = "/by-rating")
    public Page<Quote> randQuote(){
        return quoteRepository.findAll(PageRequest.of(0, 10, Sort.by("rating").descending()));

    }

    @GetMapping(value = "/by-rating-desc")
    public List<Quote> findAllOrdered() {
        return quoteRepository.findAll().stream()
                .sorted(Comparator.comparing(Quote::getRating))
                .limit(10)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/random")
    public Quote randomQuote() {
        long qty = quoteRepository.count();
        int index = (int)(Math.random() * qty);
        Page<Quote> questionPage = quoteRepository.findAll(PageRequest.of(index, 1));
        Quote quote = null;
        if (questionPage.hasContent()) {
            quote = questionPage.getContent().get(0);
        }
        return quote;
    }


}
