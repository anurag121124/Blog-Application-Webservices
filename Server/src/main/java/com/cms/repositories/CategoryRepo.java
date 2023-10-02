package com.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
