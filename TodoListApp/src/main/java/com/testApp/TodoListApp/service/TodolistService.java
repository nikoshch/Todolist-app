package com.testApp.TodoListApp.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.testApp.TodoListApp.model.Todolist;
import com.testApp.TodoListApp.repo.TodolistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodolistService implements TodoInterfase{
    @Autowired
    private TodolistRepository TodolistRepository;


    @Override
    public Todolist getById(Long id) {
        return null;
    }

    @Override
    public void save(Todolist todolist) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Todolist> getAll() {
        return null;
    }
}
