package com.example.kameleoon.model;

import java.io.Serializable;
import java.util.Objects;

public class VoteId implements Serializable {
    private User user;
    private Quote quote;

    public VoteId() {
    }

    public VoteId(User user, Quote quote) {
        this.user = user;
        this.quote = quote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteId voteId = (VoteId) o;
        return user.getId().equals(voteId.user.getId()) && quote.getId().equals(voteId.quote.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, quote);
    }
}
