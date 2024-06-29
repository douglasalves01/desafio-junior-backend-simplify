package com.example.desafio_todo.controller;

import com.example.desafio_todo.entity.TodoEntity;
import com.example.desafio_todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<TodoEntity> salvar(@RequestBody TodoEntity todo) {
        TodoEntity item = todoService.salvar(todo);
        return ResponseEntity.ok(item);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<TodoEntity>> buscarTodos() {
        List<TodoEntity> todos = todoService.buscar();
        return ResponseEntity.ok(todos);
    }
}
