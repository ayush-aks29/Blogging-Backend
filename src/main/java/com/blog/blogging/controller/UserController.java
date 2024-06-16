package com.blog.blogging.controller;

import com.blog.blogging.payload.UserDto;
import com.blog.blogging.service.UserService;
import com.blog.blogging.utility.Conversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){
        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(Map.of("message","User Deleted Successfully"),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
