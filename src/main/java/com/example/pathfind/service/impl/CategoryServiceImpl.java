package com.example.pathfind.service.impl;


import com.example.pathfind.model.entity.Category;
import com.example.pathfind.model.entity.CategoryNameEnum;
import com.example.pathfind.repository.CategoryRepository;
import com.example.pathfind.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category findCategoryByName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository
                .findByName(categoryNameEnum)
                .orElse(null);
    }
}
