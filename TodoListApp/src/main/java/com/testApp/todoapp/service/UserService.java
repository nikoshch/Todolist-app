package com.testApp.todoapp.service;

import com.testApp.todoapp.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {
    User findById(Long id);

    User findByUsername(String username);

    User seve(User user);

    void delete(Long id);

    List<User> getAll();

}
