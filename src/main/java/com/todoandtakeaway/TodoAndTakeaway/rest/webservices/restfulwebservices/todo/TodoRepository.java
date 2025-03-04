package com.todoandtakeaway.TodoAndTakeaway.rest.webservices.restfulwebservices.todo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoandtakeaway.TodoAndTakeaway.rest.webservices.restfulwebservices.todo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
    
    List<Todo> findByUsername(String username);

}
