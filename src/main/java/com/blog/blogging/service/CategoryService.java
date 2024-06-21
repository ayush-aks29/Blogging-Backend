package com.blog.blogging.service;

import com.blog.blogging.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    //c
    CategoryDto createCategory(CategoryDto categoryDto);
    //r
    CategoryDto getCategoryById(Integer categoryId);

    List<CategoryDto> getAllCategories();
    //u
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    //d
    CategoryDto deleteCategory(Integer categoryId);
}
