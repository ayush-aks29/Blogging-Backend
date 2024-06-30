package com.blog.blogging.controller;

import com.blog.blogging.config.AppConstants;
import com.blog.blogging.payload.ApiResponse;
import com.blog.blogging.payload.PostDto;
import com.blog.blogging.payload.UserDto;
import com.blog.blogging.payload.UserResponse;
import com.blog.blogging.service.UserService;
import com.blog.blogging.utility.Conversion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
//        return new ResponseEntity<>(Map.of("message","User Deleted Successfully"),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<UserResponse> getAllUsers(
            @RequestParam(value="pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false)Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false)Integer pageSize
    ){
        UserResponse userResponse = this.userService.getAllUsers(pageNumber, pageSize);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
