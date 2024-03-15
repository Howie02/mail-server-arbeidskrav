package com.example.springbootmailserver.service;

import com.example.springbootmailserver.model.User;
import com.example.springbootmailserver.repository.UserRepository;
import com.example.springbootmailserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

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

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }
}
