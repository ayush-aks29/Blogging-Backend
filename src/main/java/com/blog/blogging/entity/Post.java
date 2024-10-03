package com.blog.blogging.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Post {

    @Id
//    @SequenceGenerator(name = "postId", sequenceName = "postId", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name="post_title", length = 100, nullable=false)
    private String title;

    @Column(length = 10000, nullable=false)
    private String content;

    private Date addedDate;

//    private String imageName;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

}
