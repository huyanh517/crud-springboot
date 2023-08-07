package com.example.crud.service;

import com.example.crud.model.Todo;
import com.example.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo add(Todo todo) {
        todo.setId(UUID.randomUUID().toString().split("-")[0]);
        return todoRepository.save(todo);
    }

    public List<Todo> all() {
        return todoRepository.findAll();
    }

    public Page<Todo> allP(Pageable p) {
        return todoRepository.findAll(p);
    }

    public Todo getById(String id) {
        return todoRepository.findById(id).get();
    }

    public List<Todo> getByAssignee(String assignee) {
        return todoRepository.findByAssignee(assignee);
    }

    public Todo update(Todo todoRequest) {
        Todo selectedTodo =  todoRepository.findById(todoRequest.getId()).get();
        selectedTodo.setTitle(todoRequest.getTitle());
        selectedTodo.setAssignee(todoRequest.getAssignee());
        selectedTodo.setStatus(todoRequest.getStatus());
        return todoRepository.save(selectedTodo);
    }

    public String delete(String id) {
        todoRepository.deleteById(id);
        return "Deleted";
    }
}
