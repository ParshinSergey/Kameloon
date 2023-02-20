package com.example.kameleoon.repository;

import com.example.kameleoon.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);


}