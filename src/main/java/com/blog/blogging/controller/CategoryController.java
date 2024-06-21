package com.blog.blogging.controller;

import com.blog.blogging.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;



}
