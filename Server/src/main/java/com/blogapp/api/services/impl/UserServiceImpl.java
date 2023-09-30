package com.blogapp.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.api.entities.User;
import com.blogapp.api.payloads.UserDto;
import com.blogapp.api.repositories.UserRepo;
import com.blogapp.api.services.UserService;
import com.blogapp.api.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    
    

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = dtoToUser(userDto);
        User savedUser = userRepo.save(user);
        return userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = userRepo.save(user);
        return userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
    }

    
    //if delete api is not working please uncommet this code
//    @Override
//    public boolean  deleteUser(Integer userId) {
//        User user = userRepo.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
//        userRepo.delete(user);
//    
    @Override
    public boolean deleteUser(Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() ->  new ResourceNotFoundException("User not found with ID: " + userId, null, userId));
        userRepo.delete(user);
        return true; // Return true to indicate successful deletion
    }

    private User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    private UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

	@Override
	public UserDto registerNewUser(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserbyId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
