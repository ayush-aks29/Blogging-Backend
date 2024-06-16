package com.blog.blogging.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @SequenceGenerator(name = "user1", sequenceName = "user2", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user1")
    private int id;

    @Column(name="user_name")
    private String name;
    @Column(name="user_email")
    private String email;
    private String password;
    private String about;

}
