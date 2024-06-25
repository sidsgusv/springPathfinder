package com.example.pathfind.repository;


import com.example.pathfind.model.entity.Category;
import com.example.pathfind.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category>findByName(CategoryNameEnum categoryNameEnum);
}
