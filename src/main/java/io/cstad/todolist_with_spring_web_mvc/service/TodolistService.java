package io.cstad.todolist_with_spring_web_mvc.service;
import io.cstad.todolist_with_spring_web_mvc.model.Todo;
import io.cstad.todolist_with_spring_web_mvc.repository.TodolistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodolistService {
    private final TodolistRepository todolistRepository;
    TodolistService(TodolistRepository todolistRepository){
        this.todolistRepository = todolistRepository;
    }
    public List<Todo> getAllTodolist(){
        return todolistRepository.getAllTodoList();
    }
}
