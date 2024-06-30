package com.blog.blogging.service.implementation;

import com.blog.blogging.entity.Category;
import com.blog.blogging.exception.ResourceNotFoundException;
import com.blog.blogging.payload.CategoryDto;
import com.blog.blogging.payload.CategoryResponse;
import com.blog.blogging.repository.CategoryRepository;
import com.blog.blogging.service.CategoryService;
import com.blog.blogging.utility.Conversion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize) {

        Pageable p = PageRequest.of(pageNumber, pageSize);
        Page<Category> pageCategory = this.categoryRepository.findAll(p);
        List<Category> categories = pageCategory.getContent();
        List<CategoryDto> categoryDtoList = categories.stream().map(category->
                        conversion.categoryToDto(category))
                .collect(Collectors.toList());

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setContent(categoryDtoList);
        categoryResponse.setPageNumber(pageCategory.getNumber());
        categoryResponse.setPageSize(pageCategory.getSize());
        categoryResponse.setTotalElements(pageCategory.getTotalElements());
        categoryResponse.setTotalPages(pageCategory.getTotalPages());
        categoryResponse.setLastPage(pageCategory.isLast());

        return categoryResponse;
        
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
