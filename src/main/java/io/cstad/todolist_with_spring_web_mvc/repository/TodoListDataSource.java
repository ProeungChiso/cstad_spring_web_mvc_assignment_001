package io.cstad.todolist_with_spring_web_mvc.repository;

import io.cstad.todolist_with_spring_web_mvc.model.Todo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TodoListDataSource {
    private final List<Todo> todoList = new ArrayList<>();

    TodoListDataSource(){
        todoList.add(new Todo(1,"work 1", "for database class", false, LocalDate.now()));
        todoList.add(new Todo(2,"work 2", "for web class", false, LocalDate.now()));
        todoList.add(new Todo(3,"work 3", "for java class", true, LocalDate.now()));
        todoList.add(new Todo(4,"work 4", "for spring class", false, LocalDate.now()));
        todoList.add(new Todo(5,"work 5", "for uxui class", false, LocalDate.now()));
    }
    public List<Todo> getAllTodoList(){
        return todoList;
    }
    public Optional<Todo> getOneTodoList(Integer id){
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst();
    }
    public List<Todo> searchTask(String task){
        return todoList.stream()
                .filter(todo -> todo.getTask().contains(task) || String.valueOf(todo.isDone()).contains(task))
                .collect(Collectors.toList());
    }
    public void createTodoRow(Todo todo){
        Integer generateId = todoList.size() + 1;
        todo.setId(generateId);
        todo.setCreateAt(LocalDate.now());
        todoList.add(todo);
    }
    public void deleteTodoRowById(Integer id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
    }
    public void updateTodoRow(Integer id, String task, String description, Boolean isDone) {
        todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .ifPresent(todo -> {
                    if (task != null && !task.isEmpty()) {
                        todo.setTask(task);
                    }
                    if (description != null && !description.isEmpty()) {
                        todo.setDescription(description);
                    }
                    if (isDone != null) {
                        todo.setDone(isDone);
                    }
                });
    }

}
