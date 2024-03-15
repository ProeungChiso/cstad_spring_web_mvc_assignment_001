package io.cstad.todolist_with_spring_web_mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {
    private Integer id;
    private String task;
    private String description;
    private boolean isDone;
    private LocalDate createAt;
}
