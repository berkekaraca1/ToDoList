package com.project.todolist.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TODOLIST")
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Task")
    private String task;
    @Column(name = "Priority")
    private String priority;
    @Column(name = "CreatedAt")
    private String createdAt;
    @Column(name = "Status")
    private String status;
}
