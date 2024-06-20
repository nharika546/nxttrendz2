package com.example.nxttrendz2.service;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.repository.CategoryJpaRepository;
import com.example.nxttrendz2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryJpaService implements CategoryRepository {

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Override
    public ArrayList<Category> getcategorys() {
        List<Category> categoryList = categoryJpaRepository.findAll();
        ArrayList<Category> categorys = new ArrayList<>(categoryList);
        return categorys;
    }

    @Override
    public Category getcategoryById(int id) {
        try {
            Category category = categoryJpaRepository.findById(id).get();
            return category;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Category addcategory(Category category) {
        categoryJpaRepository.save(category);
        return category;
    }

    @Override
    public Category updatecategory(int id, Category category) {
        try {
            Category new_category = categoryJpaRepository.findById(id).get();
            if (category.getName() != null)
                new_category.setName(category.getName());
            if (category.getDescription() != null)
                new_category.setDescription(category.getDescription());
            categoryJpaRepository.save(new_category);
            return new_category;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletecategory(int id) {
        Category p = getcategoryById(id);
        if (p == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else {
            categoryJpaRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}