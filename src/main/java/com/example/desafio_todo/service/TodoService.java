package com.example.desafio_todo.service;

import com.example.desafio_todo.entity.TodoEntity;
import com.example.desafio_todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void excluir(String id){
        todoRepository.deleteById(id);
    }
    public TodoEntity atualizar(String todoId, TodoEntity todoAtualizado) {
        Optional<TodoEntity> optionalTodo = todoRepository.findById(todoId);
        if (optionalTodo.isPresent()) {
            TodoEntity todoExistente = optionalTodo.get();
            todoExistente.setNome(todoAtualizado.getNome());
            todoExistente.setDescricao(todoAtualizado.getDescricao());
            todoExistente.setRealizado(todoAtualizado.getRealizado());
            todoExistente.setPrioridade(todoAtualizado.getPrioridade());
            return todoRepository.save(todoExistente);
        } else {
            throw new IllegalArgumentException("Todo com ID " + todoId + " não encontrado.");
        }
    }


}
