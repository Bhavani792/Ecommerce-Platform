package com.ecommerce.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.user.model.User;
import com.ecommerce.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

public User register(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    if (user.getRole() == null || user.getRole().isEmpty()) {
        user.setRole("ROLE_USER");
    }

    return repository.save(user);
}
public User login(User user) {
    User existingUser = repository.findByUsername(user.getUsername())
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
        throw new RuntimeException("Invalid password");
    }

    return existingUser;
}
}