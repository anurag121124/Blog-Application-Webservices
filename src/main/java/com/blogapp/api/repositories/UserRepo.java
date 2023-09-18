package com.blogapp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // Add this import

import com.blogapp.api.entities.User;

@Repository // Add the @Repository annotation
public interface UserRepo extends JpaRepository<User, Integer> {

    // You can add custom query methods here if needed
}
