package com.blog.blogging.repository;

import com.blog.blogging.entity.Category;
import com.blog.blogging.entity.Post;
import com.blog.blogging.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}
