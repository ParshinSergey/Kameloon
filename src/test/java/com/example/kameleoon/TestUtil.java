package com.example.kameleoon;

import com.example.kameleoon.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.RequestPostProcessor;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

public class TestUtil {

   /* public static String objectToJson(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }*/

    public static MockHttpServletRequestBuilder putJson(String uri, Object body) {
        try {
            String json = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(body);
            return put(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

  /*  public static RequestPostProcessor userHttpBasic(User user) {
        return SecurityMockMvcRequestPostProcessors.httpBasic(user.getEmail(), user.getPassword());
    }

    public static RequestPostProcessor userAuth(User user) {
        return SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
    }*/


}