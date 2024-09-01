package com.project.todolist.repository;

import com.project.todolist.entities.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoList,Long> {
}
