package com.example.springbootmailserver.service;

import com.example.springbootmailserver.model.User;
import java.util.List;


// Interface defining methods for user-related services
public interface UserService {
    // Save a new user
    User saveUser(User user);

    // Delete a user by ID
    void deleteUser(Long userId);

    // Update an existing user by ID
    User updateUser(Long userId, User user);

    // Get a list of all users
    List<User> getAllUsers();

    // Get a user by ID
    User getUserById(Long userId);
}
