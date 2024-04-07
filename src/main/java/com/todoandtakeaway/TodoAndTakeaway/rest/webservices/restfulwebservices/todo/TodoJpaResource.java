package com.todoandtakeaway.TodoAndTakeaway.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TodoJpaResource {
    
    private TodoService todoService;
    private TodoRepository todoRepository;
    
    public TodoJpaResource(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }
    
    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        // System.out.println("todos1");
        // return todoService.findByUsername(username);
        return todoRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username,
            @PathVariable int id) {
        //return todoService.findById(id);
        return todoRepository.findById(id).get();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
            @PathVariable int id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username,
            @PathVariable int id, @RequestBody Todo todo) {
        todoRepository.save(todo);
        return todo;
    }
  
    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username,
             @RequestBody Todo todo) {
        // Todo createdTodo = todoService.addTodo(username, todo.getDescription(), 
        //         todo.getTargetDate(),todo.isDone() );
        
        // return createdTodo;
        todo.setUsername(username);
        todo.setId(null);
        return todoRepository.save(todo);
    }


    @GetMapping(path = "/basicauth")
    public String basicAuthCheck() {
        return "Success"; 
    }
}