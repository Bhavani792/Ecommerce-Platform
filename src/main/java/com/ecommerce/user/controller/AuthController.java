package com.ecommerce.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.user.model.User;
import com.ecommerce.user.security.JwtUtil;
import com.ecommerce.user.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
public String login(@RequestBody User user) {
    User loggedUser = userService.login(user);
    return jwtUtil.generateToken(loggedUser.getUsername(), loggedUser.getRole());
}
}