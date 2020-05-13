package com.testApp.TodoListApp.service;

import com.testApp.TodoListApp.model.Todolist;

import java.util.List;

public interface TodoInterfase {
    Todolist getById(Long id);

    void save(Todolist todolist);

    void delete(Long id);

    List<Todolist> getAll();
}
