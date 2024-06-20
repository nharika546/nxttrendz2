package com.example.nxttrendz2.repository;

import java.util.ArrayList;

import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.model.Category;

public interface ProductRepository {
    ArrayList<Product> getproducts();

    Product getproductById(int id);

    Product addproduct(Product product);

    Product updateproduct(int id, Product product);

    void deleteproduct(int id);

    Category getproductcategory(int id);
}