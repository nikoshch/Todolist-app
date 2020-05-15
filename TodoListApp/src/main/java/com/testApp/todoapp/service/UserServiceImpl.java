package com.testApp.todoapp.service;

import com.testApp.todoapp.model.User;
import com.testApp.todoapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findById(Long id) {
        User UserList = userRepository.findById(id).orElse(null);
        if (null == UserList){
            return null;
        }
        return UserList;
    }

    @Override
    public User findByUsername(String username) {
        User UseList = userRepository.findByUsername(username);
        return UseList;
    }

    @Override
    public User seve(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saveedUser = userRepository.save(user);
        return saveedUser;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getAll() {
        List<User> UserList = userRepository.findAll();
        return UserList;
    }
}
