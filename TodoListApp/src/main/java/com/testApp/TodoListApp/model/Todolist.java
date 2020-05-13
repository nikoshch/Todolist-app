package com.testApp.TodoListApp.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
/**
 * Simple JavaBean domain object that represents Todolist.
 *
 * @author nikshch
 * @version 1.0
 */

@Entity
@Table(name = "todolist")
@Getter
@Setter
@ToString
public class Todolist extends BaseEntity {

    @Column(name = "do_list")
    private String doList;

    @Column(name = "ended")
    private boolean ended;


}
