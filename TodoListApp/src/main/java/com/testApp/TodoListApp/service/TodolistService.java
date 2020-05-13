package com.testApp.TodoListApp.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.testApp.TodoListApp.model.Todolist;
import com.testApp.TodoListApp.repo.TodolistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Implementations of {@link TodolistService} interface.
 */

@Slf4j
@Service
public class TodolistService implements TodoInterfase{
    @Autowired
    TodolistRepository todolistRepository;


    @Override
    public Todolist getById(Long id) {
        return todolistRepository.findOne(id);
    }

    @Override
    public void save(Todolist todolist) {
        todolistRepository.save(todolist);

    }

    @Override
    public void edit(Todolist todolist) {
        todolistRepository.save(todolist);


    }

    @Override
    public void delete(Long id) {
       todolistRepository.delete(id);

    }

    @Override
    public List<Todolist> getAll() {
        return todolistRepository.findAll();
    }
}
