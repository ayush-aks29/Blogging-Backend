package com.blog.blogging.service.implementation;

import com.blog.blogging.entity.Comment;
import com.blog.blogging.entity.Post;
import com.blog.blogging.exception.ResourceNotFoundException;
import com.blog.blogging.payload.CommentDto;
import com.blog.blogging.repository.CommentRepository;
import com.blog.blogging.repository.PostRepository;
import com.blog.blogging.service.CommentService;
import com.blog.blogging.utility.Conversion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    private CommentRepository commentRepository;

    private Conversion conversion = new Conversion();

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepository.findById(postId).
                orElseThrow(()->
                         new ResourceNotFoundException("Post", "Id", postId)
                );

        Comment comment = conversion.dtoToComment(commentDto);
        comment.setPost(post);
        Comment savedComment = this.commentRepository.save(comment);
        return conversion.commentToDto(savedComment);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepository.findById(commentId).
                orElseThrow(()->
                        new ResourceNotFoundException("Comment","Id",commentId)
                );
        this.commentRepository.delete(comment);

    }
}
