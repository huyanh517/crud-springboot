package com.example.crud.controller;

import com.example.crud.model.Todo;
import com.example.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo add(@RequestBody Todo todo) {
        return todoService.add(todo);
    }

    @GetMapping
    public List<Todo> all() {
        return todoService.all();
    }

    @GetMapping("/p")
    public Page<Todo> allP(Pageable page) {
        return todoService.allP(page);
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable String id) {
        return todoService.getById(id);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Todo> getByAssignee(@PathVariable String assignee) {
        return todoService.getByAssignee(assignee);
    }

    @PutMapping
    public Todo update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public String delete(@PathVariable String id) {
        return todoService.delete(id);
    }
}
