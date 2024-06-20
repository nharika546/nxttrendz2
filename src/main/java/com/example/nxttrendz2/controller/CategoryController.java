package com.example.nxttrendz2.controller;

import com.example.nxttrendz2.service.CategoryJpaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.nxttrendz2.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import com.example.nxttrendz2.model.Category;

@RestController
public class CategoryController {
    @Autowired
    public CategoryJpaService categoryService;

    @GetMapping("/categories")
    public ArrayList<Category> getcategorys() {
        return categoryService.getcategorys();
    }

    @GetMapping("/categories/{id}")
    public Category getcategoryById(@PathVariable("id") int id) {
        return categoryService.getcategoryById(id);
    }

    @PostMapping("/categories")
    public Category addcategory(@RequestBody Category category) {
        return categoryService.addcategory(category);
    }

    @PutMapping("/categories/{id}")
    public Category updatecategory(@PathVariable("id") int id, @RequestBody Category category) {
        return categoryService.updatecategory(id, category);
    }

    @DeleteMapping("/categories/{id}")
    public void deletecategory(@PathVariable("id") int id) {
        categoryService.deletecategory(id);
    }
}