package io.cstad.todolist_with_spring_web_mvc.controller;
import io.cstad.todolist_with_spring_web_mvc.model.Todo;
import io.cstad.todolist_with_spring_web_mvc.service.TodolistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TodolistController {
    private final TodolistService todolistService;

    TodolistController(TodolistService todolistService){
        this.todolistService = todolistService;
    }

    @GetMapping("/todo")
    public String getAllTodolist(Model model) {
        model.addAttribute("todoLists", todolistService.getAllTodolist());
        return "index";
    }
    @GetMapping("/todo/{id}")
    public String getOneTodolist(@PathVariable("id") Integer id, Model model) {
        Optional<Todo> todoOptional = todolistService.getOneTodolist(id);
        todoOptional.ifPresent(todo -> model.addAttribute("todoLists", todo));
        return "index";
    }
    @PostMapping("/todo/new")
    public String createTodoRow(@ModelAttribute("todo") Todo todo){
        todolistService.createTodoRow(todo);
        return "redirect:/todo";
    }
    @GetMapping("/todo/delete/{id}")
    public String deleteTodoRow(@PathVariable("id") Integer id){
        todolistService.deleteTodoRowById(id);
        return "redirect:/todo";
    }
    @GetMapping("/todo/search")
    public String searchTask(@RequestParam("searchTask") String task, Model model) {
        List<Todo> foundTodos = todolistService.searchTask(task);
        model.addAttribute("todoLists", foundTodos);
        return "index";
    }
    @GetMapping("/todo/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Todo> todoOptional = todolistService.getOneTodolist(id);
        Todo todo = todoOptional.orElse(new Todo());
        model.addAttribute("todo", todo);
        return "edit";
    }
    @PostMapping("/todo/update")
    public String updateTodoRow(@ModelAttribute Todo todo, Model model) {
        todolistService.updateTodoRow(todo);
        model.addAttribute("todo", todo);
        return "redirect:/todo";
    }
}
