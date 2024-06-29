package com.blog.blogging.service;

import com.blog.blogging.payload.CategoryDto;
import com.blog.blogging.payload.CategoryResponse;
import com.blog.blogging.payload.PostResponse;

import java.util.List;

public interface CategoryService {

    //add  category
    CategoryDto createCategory(CategoryDto categoryDto);

    //get category by id
    CategoryDto getCategoryById(Integer categoryId);

    //get all categories including pagination
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize);

    //update category
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //delete category
    CategoryDto deleteCategory(Integer categoryId);
}
