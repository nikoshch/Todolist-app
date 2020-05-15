package com.testApp.todoapp.repo;

import com.testApp.todoapp.model.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TodolistRepository extends JpaRepository<Todolist, Long>{



}
