package com.example.springbootmailserver.service;

import com.example.springbootmailserver.model.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    void deleteUser(Long userId);
    User updateUser(Long userId, User user);
    List<User> getAllUsers();
    User getUserById(Long userId);
}
