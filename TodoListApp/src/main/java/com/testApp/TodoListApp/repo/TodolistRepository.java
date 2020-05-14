package com.testApp.TodoListApp.repo;

import com.testApp.TodoListApp.model.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TodolistRepository extends JpaRepository<Todolist, Long>{



}
