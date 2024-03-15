package io.cstad.todolist_with_spring_web_mvc.repository;

import io.cstad.todolist_with_spring_web_mvc.model.Todo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodolistRepository {
    private final List<Todo> todoList = new ArrayList<>();

    TodolistRepository(){
        todoList.add(new Todo(1,"work 1", "for database class", false, LocalDate.now()));
        todoList.add(new Todo(2,"work 2", "for web class", false, LocalDate.now()));
        todoList.add(new Todo(3,"work 3", "for java class", false, LocalDate.now()));
        todoList.add(new Todo(4,"work 4", "for spring class", false, LocalDate.now()));
        todoList.add(new Todo(5,"work 5", "for uxui class", false, LocalDate.now()));
    }
    public List<Todo> getAllTodoList(){
        return todoList;
    }
}
