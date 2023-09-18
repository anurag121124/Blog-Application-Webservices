package com.blogapp.api.services;
import java.util.List;
import com.blogapp.api.entities.User;
import com.blogapp.api.payloads.UserDto;

public interface UserService {
	
  UserDto  createUser(UserDto user);
  UserDto  updateUser(UserDto users,Integer userId);
  UserDto  getUserbyId(Integer userId);
  List<UserDto > getallUser();
  void deleteUser (Integer userId);
 List<UserDto> getUserbyId();
  
  
}
