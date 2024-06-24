package com.blog.blogging.controller;

import com.blog.blogging.payload.ApiResponse;
import com.blog.blogging.payload.PostDto;
import com.blog.blogging.payload.UserDto;
import com.blog.blogging.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    //post method
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @Valid
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId){
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    //get all posts by user
    @GetMapping("/user/{userId}/getPosts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
        List<PostDto> posts = this.postService.getAllPostByUser((userId));
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    //get all posts by category
    @GetMapping("/category/{categoryId}/getPosts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts = this.postService.getAllPostByCategory((categoryId));
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    //get all posts
    @GetMapping("/getAllPosts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok(this.postService.getAllPosts());
    }


    //get post by id
    @GetMapping("/getPostById/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        return ResponseEntity.ok(this.postService.getPostById(postId));
    }


    //update post
    @PutMapping("/updatePost/{postId}")
    public ResponseEntity<PostDto> updateUser(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto updatedPost = this.postService.updatePost(postDto, postId);
        return ResponseEntity.ok(updatedPost);
    }


    //delete post by postId
    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity<?> deletePostById(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Post Deleted Successfully", true), HttpStatus.OK);
    }



}
