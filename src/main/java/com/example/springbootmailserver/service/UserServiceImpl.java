package com.example.springbootmailserver.service;

import com.example.springbootmailserver.model.User;
import com.example.springbootmailserver.repository.UserRepository;
import com.example.springbootmailserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


// User service component managed by Spring
@Service
public class UserServiceImpl implements UserService{

    // Dependency injection of UserRepo
    private final UserRepository userRepository;

    // Constructor injection of EmailRepo
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Implementation of saveUser method
    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    // Delete user method
    @Override
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }


    // Method for updating user info
    @Override
    public User updateUser(Long userId, User user){
        return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    return userRepository.save(existingUser);
                }).orElseGet(() -> {
                    user.setID(userId);
                    return userRepository.save(user);
                });
    }

    //Method to get all users
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Method to get a user by user ID
    @Override
    public User getUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }
}
