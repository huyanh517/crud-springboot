package com.example.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Todo {
    @Id
    private String id;
    private String title;
    private String assignee;
    private String status;
}
