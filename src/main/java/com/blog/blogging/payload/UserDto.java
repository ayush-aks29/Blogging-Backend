package com.blog.blogging.payload;

import javax.validation.constraints.*;

import com.blog.blogging.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Email(message = "Invalid email address")
    @Pattern(regexp = "^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$", message = "Enter a valid email address")
    private String email;

    @NotEmpty
    @Size(min=8, message = "Password must be of at least 8 characters")
    private String password;

    @NotEmpty
    @Size(min=10, message = "Minimum 10 characters required")
    private String about;

    private Set<RoleDto> roles = new HashSet<>();

}
