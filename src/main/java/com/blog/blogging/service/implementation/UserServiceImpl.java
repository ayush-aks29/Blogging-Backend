package com.blog.blogging.service.implementation;

import com.blog.blogging.entity.User;
import com.blog.blogging.exception.ResourceNotFoundException;
import com.blog.blogging.payload.UserDto;
import com.blog.blogging.repository.UserRepository;
import com.blog.blogging.service.UserService;
import com.blog.blogging.utility.Conversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    Conversion convert = new Conversion();

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = convert.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return convert.userToDto(savedUser);

    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepository.findById(userId).
                orElseThrow((() ->
                        new ResourceNotFoundException("User","Id", userId))
        );
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepository.save(user);
        return convert.userToDto(updatedUser);
    }

    @Override
    public UserDto deleteUser(Integer userId) {

        User user = this.userRepository.findById(userId).
                orElseThrow((() ->
                        new ResourceNotFoundException("User","Id", userId))
                );
        this.userRepository.delete(user);

        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtoList = users.stream().map(user->
                        convert.userToDto(user))
                        .collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.userRepository.findById(userId).
                orElseThrow((() ->
                        new ResourceNotFoundException("User","Id", userId))
                );

        return convert.userToDto(user);
    }



}
