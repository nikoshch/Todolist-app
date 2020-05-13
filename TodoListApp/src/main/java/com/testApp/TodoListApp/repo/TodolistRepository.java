package com.testApp.TodoListApp.repo;

import com.testApp.TodoListApp.model.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Todolist} class.
 *
 * @author nikshch
 * @version 1.0
 */

public interface TodolistRepository extends JpaRepository<Todolist, Long>{



}
