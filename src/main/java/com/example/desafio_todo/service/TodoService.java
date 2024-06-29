package com.example.desafio_todo.service;

import com.example.desafio_todo.entity.TodoEntity;
import com.example.desafio_todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity todo) {
        return todoRepository.save(todo);
    }

    public List<TodoEntity> buscar() {
        return todoRepository.findAll();
    }

}
