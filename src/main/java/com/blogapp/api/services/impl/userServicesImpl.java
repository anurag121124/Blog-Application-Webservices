package com.blogapp.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired; // Add this import
import org.springframework.stereotype.Service;

import com.blogapp.api.entities.User;
import com.blogapp.api.payloads.UserDto;
import com.blogapp.api.repositories.UserRepo;
import com.blogapp.api.services.UserService;
import com.blogapp.api.exception.ResourceNotFoundException;

@Service
public class userServicesImpl  implements UserService { // Changed class name to follow Java naming conventions
    private final UserRepo userRepo; // Make userRepo final

    @Autowired // Add constructor injection
    public userServicesImpl (UserRepo userRepo) {
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
    public UserDto getUserbyId(Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return userToDto(user);
    }

   

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto) {
        User user = new User();
        // Assign properties from userDto to user
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

    private UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        // Assign properties from user to userDto
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }

	@Override
	public List<UserDto> getallUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
