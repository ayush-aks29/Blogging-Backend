package com.blog.blogging.payload;

import com.blog.blogging.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    private Integer id;

    private String content;

//    private Post post;


}
