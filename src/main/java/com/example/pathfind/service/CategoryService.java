package com.example.pathfind.service;


import com.example.pathfind.model.entity.Category;
import com.example.pathfind.model.entity.CategoryNameEnum;

public interface CategoryService {

    Category findCategoryByName(CategoryNameEnum categoryNameEnum);
}
