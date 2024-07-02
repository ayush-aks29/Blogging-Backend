package com.blog.blogging.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    @Id
    @SequenceGenerator(name = "postId", sequenceName = "postId", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postId")
    private Integer postId;

    @Column(name="post-title", length = 100, nullable=false)
    private String title;

    @Column(length = 10000, nullable=false)
    private String content;
    private Date addedDate;
    private String imageName;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

}
