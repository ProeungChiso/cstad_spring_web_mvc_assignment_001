package io.cstad.todolist_with_spring_web_mvc.controller;
import io.cstad.todolist_with_spring_web_mvc.service.TodolistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodolistController {
    private final TodolistService todolistService;

    TodolistController(TodolistService todolistService){
        this.todolistService = todolistService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todoLists", todolistService.getAllTodolist());
        return "index";
    }
}
