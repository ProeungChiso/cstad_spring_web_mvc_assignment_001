package io.cstad.todolist_with_spring_web_mvc.service;
import io.cstad.todolist_with_spring_web_mvc.model.Todo;
import io.cstad.todolist_with_spring_web_mvc.repository.TodoListDataSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodolistService {
    private final TodoListDataSource todolistDataSource;
    TodolistService(TodoListDataSource todolistDataSource){
        this.todolistDataSource = todolistDataSource;
    }
    public List<Todo> getAllTodolist(){
        return todolistDataSource.getAllTodoList();
    }
    public Optional<Todo> getOneTodolist(Integer id){
        return todolistDataSource.getOneTodoList(id);
    }
    public void createTodoRow(Todo todo){
        todolistDataSource.createTodoRow(todo);
    }
    public void deleteTodoRowById(Integer id){
        todolistDataSource.deleteTodoRowById(id);
    }
    public List<Todo> searchTask(String task){
        return todolistDataSource.searchTask(task);
    }
    public void updateTodoRow(Todo todo) {
        todolistDataSource.updateTodoRow(todo.getId(), todo);
    }

}
