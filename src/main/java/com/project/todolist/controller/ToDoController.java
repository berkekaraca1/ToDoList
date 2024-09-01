package com.project.todolist.controller;

import com.project.todolist.entities.DeleteRequest;
import com.project.todolist.entities.ToDoList;
import com.project.todolist.repository.ToDoRepository;
import com.project.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/todos")
public class ToDoController {
    private final ToDoService toDoService;
    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoController(ToDoService toDoService, ToDoRepository toDoRepository) {
        this.toDoService = toDoService;
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/get")
    public List<ToDoList> getToDoList() {
        return toDoService.getAllToDoList();
    }

    @PostMapping("/save")
    public List<ToDoList> saveToDoList(@RequestBody ToDoList toDoList) {
        return toDoService.saveToDoList(toDoList.getTask(), toDoList.getPriority(), toDoList.getCreatedAt(), toDoList.getStatus());
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteToDoList(@RequestBody DeleteRequest deleteRequest) {
        toDoRepository.deleteById(deleteRequest.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}