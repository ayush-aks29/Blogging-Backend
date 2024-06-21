package com.blog.blogging.payload;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String about;

}
