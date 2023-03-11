package com.example.kameleoon.controller;

import com.example.kameleoon.model.Vote;
import com.example.kameleoon.service.VoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/quotes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Vote Controller")
public class VoteController {

    VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping(value = "/{quoteId}/votes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> createVote(@PathVariable Long quoteId, @RequestBody Vote vote){

        Vote savedVote = voteService.createVote(quoteId, vote);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/quotes/{quoteId}")
                .buildAndExpand(quoteId).toUri();

        return ResponseEntity.created(uriOfNewResource).body(savedVote);

    }

    @GetMapping(value = "/{quoteId}/votes/evolution")
    public List<Vote> getEvolution(@PathVariable Long quoteId){
        return voteService.getEvolution(quoteId);
    }


}
