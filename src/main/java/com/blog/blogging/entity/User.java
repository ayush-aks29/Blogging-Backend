package com.blog.blogging.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="user_name")
    private String name;
    @Column(name="user_email")
    private String email;
    private String password;
    private String about;

}
