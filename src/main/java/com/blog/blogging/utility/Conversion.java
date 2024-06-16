package com.blog.blogging.utility;

import com.blog.blogging.entity.User;
import com.blog.blogging.payload.UserDto;
import com.blog.blogging.service.implementation.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan
public class Conversion {

    @Autowired
    public UserServiceImpl userServiceImpl;

//    @Autowired
    public ModelMapper modelMapper=new ModelMapper();


    public User dtoToUser(UserDto userDto){
        /*
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
        */

        return modelMapper.map(userDto, User.class);

    }

    public UserDto userToDto(User user){
        /*
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
        */
        return modelMapper.map(user, UserDto.class);
    }

}
