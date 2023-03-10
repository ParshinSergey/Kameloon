package com.example.kameleoon.service;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.Vote;
import com.example.kameleoon.repository.QuoteRepository;
import com.example.kameleoon.repository.VoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    VoteRepository voteRepository;
    QuoteRepository quoteRepository;

    public VoteService(VoteRepository voteRepository, QuoteRepository quoteRepository) {
        this.voteRepository = voteRepository;
        this.quoteRepository = quoteRepository;
    }

    @Transactional
    public Vote createVote(Long quoteId, Vote vote){

        Quote quote = quoteRepository.findById(quoteId).orElseThrow();
        Optional<Vote> oldVote = voteRepository.findByUserAndQuote(vote.getUser(), quote);
        if (oldVote.isPresent()){
            return oldVote.get();
        }

        Integer rating = quote.getRating();
        quote.setRating(vote.isStatus() ? rating + 1 : rating - 1);
        vote.setQuote(quoteRepository.save(quote));

        return voteRepository.save(vote);

    }

    public List<Vote> getEvolution(Long quoteId) {
        return voteRepository.findAllByQuoteIdOrderByRegistered(quoteId);
    }
}
