package com.blog.blogging.service;

import com.blog.blogging.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto deleteUser(Integer userId);
    List<UserDto> getAllUsers();
    UserDto getUserById(Integer userId);


}
