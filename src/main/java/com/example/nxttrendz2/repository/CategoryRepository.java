package com.example.nxttrendz2.repository;

import java.util.ArrayList;

import com.example.nxttrendz2.model.Category;

public interface CategoryRepository {
    ArrayList<Category> getcategorys();

    Category getcategoryById(int categoryId);

    Category addcategory(Category category);

    Category updatecategory(int categoryId, Category category);

    void deletecategory(int categoryId);
}