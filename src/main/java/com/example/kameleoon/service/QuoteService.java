package com.example.kameleoon.service;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.repository.QuoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.lang.String.format;

@Service
public class QuoteService {

    QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }


    public Quote getQuoteById(long id) {
        return quoteRepository.findById(id).orElseThrow(() -> new NoSuchElementException(format("No quote with id = %d", id)));
    }

    public Quote createQuote(Quote quote){
        return quoteRepository.save(quote);
    }

    @Transactional
    public void updateQuote(long id, Quote quote) {

        // here must be check user_id
        quote.setUser(getQuoteById(id).getUser());
        quote.setId(id);
        quoteRepository.save(quote);
    }

    public void deleteById(long id){
        quoteRepository.deleteById(id);
    }

    public Page<Quote> findFlop10(){
        return quoteRepository.findAll(PageRequest.of(0, 10, Sort.by("rating").descending()));
    }

    public List<Quote> findTop10() {
        return StreamSupport.stream(quoteRepository.findAll().spliterator(), false)
                .sorted(Comparator.comparing(Quote::getRating))
                .limit(10)
                .collect(Collectors.toList());
    }

    public Quote randomQuote() {
        long qty = quoteRepository.count();
        int index = (int) ThreadLocalRandom.current().nextLong(qty);
        Page<Quote> questionPage = quoteRepository.findAll(PageRequest.of(index, 1));
        Quote quote = null;
        if (questionPage.hasContent()) {
            quote = questionPage.getContent().get(0);
        }
        return quote;
    }


}
