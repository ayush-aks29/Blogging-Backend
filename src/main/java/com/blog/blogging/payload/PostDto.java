package com.blog.blogging.payload;

import com.blog.blogging.entity.Comment;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDto {

    private Integer postId;

    private String title;

    private String content;

//    private String imageName;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;

    private Set<CommentDto> comments = new HashSet<>();




}
