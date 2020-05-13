package com.testApp.TodoListApp.service;

import com.testApp.TodoListApp.model.Todolist;
import com.testApp.TodoListApp.repo.TodolistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Repository interface for {@link TodoInterfase} interface.
 *
 * @author nikshch
 * @version 1.0
 *
 */

@Slf4j
@Service
public class TodolistService implements TodoInterfase{
    @Autowired
    TodolistRepository todolistRepository;


    @Override
    public Todolist getById(Long id) {
        log.info("IN TodolistService getById {}", id);
        return todolistRepository.getOne(id);
    }

    @Override
    public void save(Todolist todolist) {
        log.info("IN TodolistService save {}", todolist);
        todolistRepository.save(todolist);

    }

    @Override
    public void edit(Todolist todolist) {
        log.info("IN TodolistService edit {}", todolist);
        todolistRepository.save(todolist);


    }

    @Override
    public void delete(Long id) {
        log.info("IN TodolistService delete {}", id);
       todolistRepository.deleteById(id);

    }

    @Override
    public List<Todolist> getAll() {
        log.info("IN TodolistService getAll");
        return todolistRepository.findAll();
    }
}
