package com.blogapp.api.services.impl;

import com.blogapp.api.entities.Category;
import com.blogapp.api.exception.ResourceNotFoundException;
import com.blogapp.api.payloads.CategoryDto;
import com.blogapp.api.repositories.CategoryRepo;
import com.blogapp.api.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl  implements CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
     Category cat =   this.modelMapper.map(categoryDto, Category.class);
     Category addedCat =this.categoryRepo.save(cat);
     return this.modelMapper.map(addedCat,CategoryDto.class);


    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

        Category cat = this.categoryRepo.findAllById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId))
        cat.setCategoryDescription(categoryDto);


        return null;
    }

    @Override
    public void deleteCategory(Integer categoryId) {

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<CategoryDto> getCategories() {
        return null;
    }
}
