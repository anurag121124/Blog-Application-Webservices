package com.blogapp.api.services;
import java.util.List;
import com.blogapp.api.entities.User;
import com.blogapp.api.payloads.UserDto;
public interface UserService {

    UserDto registerNewUser(UserDto user);

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();
// If delete api is not working make it void 
    boolean deleteUser(Integer userId);

	UserDto getUserbyId(Integer userId);
}
