package com.todoandtakeaway.TodoAndTakeaway.rest.webservices.restfulwebservices.user;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoandtakeaway.TodoAndTakeaway.rest.webservices.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    // User findByUsername(String username);

}