package com.blog.blogging.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @SequenceGenerator(name = "userId", sequenceName = "userId", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId")
    private int id;

    @Column(name="user_name")
    private String name;

    @Column(name="user_email")
    private String email;

    private String password;

    private String about;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

}
