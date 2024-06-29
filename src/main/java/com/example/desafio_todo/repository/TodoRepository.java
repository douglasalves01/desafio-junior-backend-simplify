package com.example.desafio_todo.repository;

import com.example.desafio_todo.entity.TodoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoEntity, Long> {
}
