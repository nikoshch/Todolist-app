package com.testApp.TodoListApp.rest;

import com.testApp.TodoListApp.model.Todolist;
import com.testApp.TodoListApp.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todolist/")
public class TodolistRestController {
    @Autowired
    private TodolistService todolistService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todolist> getTodolist(@PathVariable("id")Long todolistId){
        if (todolistId == null){
            return new ResponseEntity<Todolist>(HttpStatus.BAD_REQUEST);
        }
        Todolist todolist = this.todolistService.getById(todolistId);
        if (todolistId == null){
            return new ResponseEntity<Todolist>(HttpStatus.NOT_FOUND);
        }


     return new ResponseEntity<Todolist>(todolist, HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todolist> saveTodolist(@RequestBody @Valid Todolist todolist){
        HttpHeaders headers = new HttpHeaders();
        if (todolist == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.todolistService.save(todolist);
        return new ResponseEntity<>(todolist,headers,HttpStatus.CREATED);

    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todolist> editTodolist(@RequestBody @Valid Todolist todolist){
        HttpHeaders headers = new HttpHeaders();
        if (todolist == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.todolistService.edit(todolist);
        return new ResponseEntity<>(todolist,headers,HttpStatus.CREATED);

    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todolist>deletTodolist(@PathVariable("id")Long id){
        Todolist todolist = this.todolistService.getById(id);
        if (todolist == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
        this.todolistService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @RequestMapping(value = "",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Todolist>> getAllTodolist(){
        List<Todolist> todolists = this.todolistService.getAll();
        if (todolists.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todolists,HttpStatus.OK);
    }

}
