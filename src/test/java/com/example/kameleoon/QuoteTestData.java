package com.example.kameleoon;

import com.example.kameleoon.model.Quote;

public class QuoteTestData {

    public static Quote quote1 = new Quote();
    static {
        quote1.setId(1L);
        quote1.setContent("1st Article");
        quote1.setRating(3);
    }

    public static Quote getQuoteUpdated(Quote quote){
        quote.setContent("Updated Article!!");
        return quote;
    }
}
