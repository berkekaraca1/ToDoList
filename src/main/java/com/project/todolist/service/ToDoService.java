package com.project.todolist.service;

import com.project.todolist.entities.ToDoList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoService {
    List<ToDoList> saveToDoList(String task,String priority, String createdAt, String status);
    List<ToDoList> getAllToDoList();
}
