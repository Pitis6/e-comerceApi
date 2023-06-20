package com.felipe.ecomrecev1.repository;

import com.felipe.ecomrecev1.model.Product;

import java.util.List;

public interface ProductRepository {
    Product createProduct(Product product);
    List<Product> findAll();
    Product findProductById(String id);
    Product updateProduct(String id, Product product);
    Boolean deleteProduct(String id);
    Boolean deleteAllProducts();
    Long upadateProductPatch(String id, Product product);
}
