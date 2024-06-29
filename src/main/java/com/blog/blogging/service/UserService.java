package com.blog.blogging.service;

import com.blog.blogging.payload.UserDto;
import com.blog.blogging.payload.UserResponse;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto deleteUser(Integer userId);

    UserResponse getAllUsers(Integer pageNumber, Integer pageSize);

    UserDto getUserById(Integer userId);


}
