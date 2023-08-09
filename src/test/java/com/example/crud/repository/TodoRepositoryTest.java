package com.example.crud.repository;

import com.example.crud.model.Todo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.UUID;

@DataMongoTest
public class TodoRepositoryTest {
    @Autowired
    private TodoRepository  todoRepository;

//    Junit test for save todo
    @Test
    public void givenTodoObject_whenSave_thenReturnSaveTodo() {
//      given - precondition or setup
        Todo todo = new Todo(UUID.randomUUID().toString().split("-")[0], "Todo Test", "Huy Anh", "Completed");
//      when - action or behavior that we are going test
        Todo savedTodo = todoRepository.save(todo);
//        then - verify output
        Assertions.assertThat(savedTodo).isNotNull();
        Assertions.assertThat(savedTodo.getId()).isNotEmpty();
    }


//    JUnit test for getAll todo

    @Test

    public void givenListTodo_when_then() {
//        given - setup


    }

}
