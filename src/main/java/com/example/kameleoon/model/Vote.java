package com.example.kameleoon.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@IdClass(VoteId.class)
public class Vote {

    private boolean status;

    private LocalDate registered = LocalDate.now();

    @ManyToOne
    @Id
    private User user;

    @ManyToOne
    @Id
    @JoinColumn(name="quote_id")
    private Quote quote;

    public Vote() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}