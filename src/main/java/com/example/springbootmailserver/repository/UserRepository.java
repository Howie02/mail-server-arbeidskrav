package com.example.springbootmailserver.repository;

import com.example.springbootmailserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Repository component for Users managed by Spring
public interface UserRepository extends JpaRepository<User, Long>{
    // Method to find a user by username
    Optional<User> findByUsername(String username);

    // Method to find a user by email
    Optional<User> findByEmail(String email);
}
