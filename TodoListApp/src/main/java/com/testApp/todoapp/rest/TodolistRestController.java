package com.testApp.todoapp.rest;

import com.testApp.todoapp.model.Todolist;
import com.testApp.todoapp.service.TodolistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todolist")
public class TodolistRestController {
    @Autowired
    private TodolistServiceImpl todolistService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todolist> getTodolist(@PathVariable("id")Long todolistId){
        Todolist todolist = this.todolistService.getById(todolistId);

        if (todolist == null){
            return new ResponseEntity<Todolist>(HttpStatus.NOT_FOUND);
        }


     return new ResponseEntity<Todolist>(todolist, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todolist> saveTodoList(@RequestBody @Valid Todolist todolist) {
        Todolist saved = this.todolistService.save(todolist);

        return new ResponseEntity<>(saved,HttpStatus.CREATED);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todolist> editTodolist(@PathVariable("id")Long todolistId, @RequestBody @Valid Todolist todolist){
        if (!todolistId.equals(todolist.getId())) {
            return ResponseEntity.badRequest().build();
        }

        if (todolistService.getById(todolistId) == null) {
            return ResponseEntity.badRequest().build();
        }
        Todolist edited = this.todolistService.edit(todolist);

        return new ResponseEntity<>(edited,HttpStatus.OK);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todolist>deletTodolist(@PathVariable("id")Long id){
        Todolist todolist = this.todolistService.getById(id);
        if (todolist == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
        this.todolistService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Todolist>> getAllTodolist(){
        return new ResponseEntity<>(this.todolistService.getAll(),HttpStatus.OK);
    }

}
