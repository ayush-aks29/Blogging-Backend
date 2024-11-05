package com.blog.blogging.payload;

import lombok.Data;

@Data
public class JwtAuthRequest {

    private String username;
    private String password;

}
