package com.blog.blogging.service.implementation;

import com.blog.blogging.entity.Category;
import com.blog.blogging.exception.ResourceNotFoundException;
import com.blog.blogging.payload.CategoryDto;
import com.blog.blogging.repository.CategoryRepository;
import com.blog.blogging.service.CategoryService;
import com.blog.blogging.utility.Conversion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    public ModelMapper modelMapper;

    private Conversion conversion = new Conversion();

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = conversion.dtoToCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return conversion.categoryToDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).
                orElseThrow((() ->
                        new ResourceNotFoundException("Category","Id", categoryId))
                );

        return conversion.categoryToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = categories.stream().map(category->
                        conversion.categoryToDto(category))
                .collect(Collectors.toList());
        return categoryDtoList;
    }
//categoryTitle, categoryDescription
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).
                orElseThrow((() ->
                        new ResourceNotFoundException("Category","Id", categoryId))
                );
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCategory = this.categoryRepository.save(category);
        return conversion.categoryToDto(updatedCategory);
    }

    @Override
    public CategoryDto deleteCategory(Integer categoryId) {

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow((() ->
                        new ResourceNotFoundException("Category","Id", categoryId))
                );
        this.categoryRepository.delete(category);
        return conversion.categoryToDto(category);

    }

}
