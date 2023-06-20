package com.felipe.ecomrecev1.controller;


import com.felipe.ecomrecev1.model.Product;
import com.felipe.ecomrecev1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductContoller {
    private final ProductService productService;

    @Autowired
    public ProductContoller(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product productCreated = productService.createProduct(product);
        if(productCreated != null){
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
        }else {
            return new ResponseEntity("Error crating product", HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> allProducts(){
        List<Product> allProducts = productService.findAll();
        if(allProducts.size() == 0){
            return new ResponseEntity("The colection is empty", HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(allProducts,HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable String id){
        Product productFound = productService.findProductById(id);
        if(productFound != null){
            return new ResponseEntity<>(productFound, HttpStatus.OK);
        }else {
            return new ResponseEntity("Not found product with id: "+ id ,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product){
        Product productUpadated = productService.updateProduct(id, product);
        if(productUpadated != null){
            return new ResponseEntity<>(productUpadated,HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity("Not found product with id: "+ id,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable String id){
       if(productService.deleteProduct(id) == true){
        return new ResponseEntity("Product with id: " + id +  " was deleted ", HttpStatus.ACCEPTED);
       }else {
           return new ResponseEntity("The product was not found with id: "+id,HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAllProducts(){
        if(productService.deleteAllProducts()){
            return new ResponseEntity("All products was deleted",HttpStatus.OK);
        }else {
            return new ResponseEntity("Error was ocurred",HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Long> updatePatch(@PathVariable String id, @RequestBody Product product){
        Long updatedProduct = productService.upadateProductPatch(id,product);
        if (updatedProduct==0){
            return new ResponseEntity("The product was not found with id: "+id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

}
