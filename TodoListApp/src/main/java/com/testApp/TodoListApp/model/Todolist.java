package com.testApp.TodoListApp.model;


import lombok.ToString;

import javax.persistence.*;

@MappedSuperclass
@Entity

@ToString
public class Todolist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dolist;
    private boolean endet;

    public Todolist(Long id, String dolist, boolean endet) {
        this.id = id;
        this.dolist = dolist;
        this.endet = endet;
    }

    public Long getId(Long id) {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDolist() {
        return dolist;
    }

    public void setDolist(String dolist) {
        this.dolist = dolist;
    }

    public boolean isEndet() {
        return endet;
    }

    public void setEndet(boolean endet) {
        this.endet = endet;
    }
}
