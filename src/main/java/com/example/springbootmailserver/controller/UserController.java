package com.example.springbootmailserver.controller;

import com.example.springbootmailserver.model.User;
import com.example.springbootmailserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users") // Base path for all request mappings in userController
public class UserController {
    private final UserService userService;

    // Constructor-based dependency injection for the UserService
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // POST mapping to create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // GET mapping to retrieve all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // GET mapping to retrieve a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return user!= null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PUT mapping to update a user by ID
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User updatedUser = userService.updateUser(id, userDetails);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // DELETE mapping to delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
