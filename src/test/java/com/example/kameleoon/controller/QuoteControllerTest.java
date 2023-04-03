package com.example.kameleoon.controller;

import com.example.kameleoon.QuoteTestData;
import com.example.kameleoon.model.Quote;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.kameleoon.TestUtil.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class QuoteControllerTest extends AbstractControllerTest {

    static final String URL = "/api/quotes/";

    @Autowired
    private QuoteController controller;

    @Test
    void getById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() throws Exception {
        Quote quote = controller.getById(1).getBody();
        Quote updatedQuote = QuoteTestData.getQuoteUpdated(quote);
        perform(putJson(URL + "1", updatedQuote))
                .andExpect(status().isNoContent());
    }

    @Test
    void delete() {
        controller.delete(1);
        assertEquals(HttpStatus.NOT_FOUND, controller.getById(1).getStatusCode());
    }

}