package com.blog.blogging.service;

import com.blog.blogging.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);



}
