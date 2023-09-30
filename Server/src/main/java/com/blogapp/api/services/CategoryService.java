package com.blogapp.api.services;

import com.blogapp.api.payloads.CategoryDto;

import java.util.List;


public interface CategoryService {


    //Create
    CategoryDto createCategory(CategoryDto categoryDto);

    // Update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // Delete
    void deleteCategory(Integer categoryId);

    // Get
    CategoryDto getCategory(Integer categoryId);

    // Get All
    List<CategoryDto> getCategories();


}
