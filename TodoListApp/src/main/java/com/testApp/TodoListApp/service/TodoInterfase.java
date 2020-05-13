package com.testApp.TodoListApp.service;

import com.testApp.TodoListApp.model.Todolist;

import java.util.List;

/**
 * Service interface for {@link Todolist} class.
 * @author nikshch
 * @version 1.0
 */

public interface TodoInterfase {
    Todolist getById(Long id);

    void save(Todolist todolist);

    void edit(Todolist todolist);

    void delete(Long id);

    List<Todolist> getAll();
}
