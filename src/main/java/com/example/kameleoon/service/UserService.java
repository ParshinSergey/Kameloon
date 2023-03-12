package com.example.kameleoon.service;

import com.example.kameleoon.model.User;
import com.example.kameleoon.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user) {
        Optional<User> optionalUser = userRepository.findByEmailIgnoreCase(user.getEmail());
        if (optionalUser.isPresent()) throw new ResponseStatusException(HttpStatus.CONFLICT, "This email already exists");
        return userRepository.save(user);
    }
}
