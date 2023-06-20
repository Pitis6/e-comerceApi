package com.felipe.ecomrecev1.service;


import com.felipe.ecomrecev1.model.Product;
import com.felipe.ecomrecev1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.createProduct(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Product updateProduct(String id, Product product) {
        return productRepository.updateProduct(id,product);
    }

    @Override
    public Boolean deleteProduct(String id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public Boolean deleteAllProducts() {
        return productRepository.deleteAllProducts();
    }

    @Override
    public Long upadateProductPatch(String id, Product product) {

        return productRepository.upadateProductPatch(id, product);
    }
}
