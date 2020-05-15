package com.testApp.todoapp.security.jwt;

import com.testApp.todoapp.model.User;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user){
        return new JwtUser(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword());
    }

}
