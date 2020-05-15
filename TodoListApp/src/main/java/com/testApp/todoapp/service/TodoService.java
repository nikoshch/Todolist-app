package com.testApp.todoapp.service;

import com.testApp.todoapp.model.Todolist;

import java.util.List;



public interface TodoService {
    Todolist getById(Long id);

    Todolist save(Todolist todolist);

    Todolist edit(Todolist todolist);

    void delete(Long id);

    List<Todolist> getAll();
}
