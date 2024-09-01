package com.project.todolist.service.impl;

import com.project.todolist.entities.ToDoList;
import com.project.todolist.repository.ToDoRepository;
import com.project.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{
    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://localhost:5432/ToDoList").build();
    }
    @Override
    public List<ToDoList> saveToDoList(String task, String priority, String createdAt, String status){
        ToDoList toDoList = new ToDoList();
        toDoList.setTask(task);
        toDoList.setPriority(priority);
        toDoList.setCreatedAt(createdAt);
        toDoList.setStatus(status);

        toDoRepository.save(toDoList);

        return List.of(toDoList);
    }

    @Override
    public List<ToDoList> getAllToDoList() {
        return toDoRepository.findAll();
    }
}