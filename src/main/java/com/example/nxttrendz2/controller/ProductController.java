package com.example.nxttrendz2.controller;

import com.example.nxttrendz2.service.ProductJpaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.nxttrendz2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import com.example.nxttrendz2.model.Category;

@RestController
public class ProductController {
    @Autowired
    public ProductJpaService productService;

    @GetMapping("/products/{id}/category")
    public Category getproductcategory(@PathVariable("id") int id) {
        return productService.getproductcategory(id);
    }

    @GetMapping("/categories/products")
    public ArrayList<Product> getproducts() {
        return productService.getproducts();
    }

    @GetMapping("/categories/products/{id}")
    public Product getproductById(@PathVariable("id") int id) {
        return productService.getproductById(id);
    }

    @PostMapping("/categories/products")
    public Product addproduct(@RequestBody Product product) {
        return productService.addproduct(product);
    }

    @PutMapping("/categories/products/{id}")
    public Product updateproduct(@PathVariable("id") int id, @RequestBody Product product) {
        return productService.updateproduct(id, product);
    }

    @DeleteMapping("/categories/products/{id}")
    public void deleteproduct(@PathVariable("id") int id) {
        productService.deleteproduct(id);
    }
}