package com.testApp.todoapp.service;

import com.testApp.todoapp.model.Todolist;
import com.testApp.todoapp.repo.TodolistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class TodolistServiceImpl implements TodoService {
    @Autowired
    TodolistRepository todolistRepository;


    @Override
    public Todolist getById(Long id) {
        log.info("IN TodolistService getById {}", id);

        Optional<Todolist> todo = todolistRepository.findById(id);
        if(todo.isPresent()) {
            return todo.get();
        }

        return null;
    }

    @Override
    public Todolist save(Todolist todolist) {
        log.info("IN TodolistService save {}", todolist);

        return todolistRepository.save(todolist);

    }

    @Override
    public Todolist edit(Todolist todolist) {
        log.info("IN TodolistService edit {}", todolist);

        return todolistRepository.save(todolist);


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
