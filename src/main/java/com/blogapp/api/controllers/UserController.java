package com.blogapp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired; // Add this import
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.api.payloads.UserDto;
import com.blogapp.api.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService; // Declare userService as final

    @Autowired // Inject the UserService bean
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST - Create users
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    // PUT - Update users
    // Add your update logic here

    // DELETE - Delete users
    // Add your delete logic here

    // GET - Get Users
    // Add your get logic here
}
