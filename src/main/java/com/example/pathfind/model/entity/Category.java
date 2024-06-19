package com.example.pathfind.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{


    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {

    }



    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
