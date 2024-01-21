package com.example.projektsklep.controller;

import com.example.projektsklep.model.entities.product.CategoryEmbeddable;
import com.example.projektsklep.model.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryTreeController {

    private final CategoryRepository categoryRepository;

    public CategoryTreeController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/category-tree")
    public List<Object> getCategoryTree() {
        return categoryRepository.findAll().stream()
                .map(CategoryEmbeddable::toTreeDTO)
                .collect(Collectors.toList());
    }


}