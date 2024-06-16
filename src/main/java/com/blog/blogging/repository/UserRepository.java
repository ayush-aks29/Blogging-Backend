package com.blog.blogging.repository;

import com.blog.blogging.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {



}
