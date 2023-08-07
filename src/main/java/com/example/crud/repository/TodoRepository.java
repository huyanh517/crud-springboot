package com.example.crud.repository;

import com.example.crud.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

    public interface TodoRepository extends MongoRepository<Todo,String> {
        List<Todo> findByAssignee(String assignee);

}
