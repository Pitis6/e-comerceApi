package com.felipe.ecomrecev1.repository;

import com.felipe.ecomrecev1.model.Product;
import com.felipe.ecomrecev1.repository.mongoRepository.ProductsMongoRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductsMongoRepository productsMongoRepository;

    private final MongoTemplate mongoTemplate;


    @Autowired
    public ProductRepositoryImpl(ProductsMongoRepository productsMongoRepository, MongoTemplate mongoTemplate) {
        this.productsMongoRepository = productsMongoRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        return productsMongoRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productsMongoRepository.findAll();
    }

    @Override
    public Product findProductById(String id) {
        Optional<Product> productFound = productsMongoRepository.findById(id);
        if (productFound.isPresent()){
            return productFound.get();
        }
        return null;
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product productToUpdate = findProductById(id);
        if ( productToUpdate != null) {
            productToUpdate.setSlug(product.getSlug());
            productToUpdate.setName(product.getName());
            productToUpdate.setImage(product.getImage());
            productToUpdate.setCategory(product.getCategory());
            productToUpdate.setCategoryImage(product.getCategoryImage());
            productToUpdate.setNew(product.getNew());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setFeatures(product.getFeatures());
            productToUpdate.setIncludes(product.getIncludes());
            productToUpdate.setGallery(product.getGallery());
            return productsMongoRepository.save(productToUpdate);
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteProduct(String id) {
        Product productToUpdate = findProductById(id);
        if(productToUpdate != null) {
            productsMongoRepository.delete(productToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteAllProducts() {
        productsMongoRepository.deleteAll();
        return true;
    }

    @Override
    public Long upadateProductPatch(String id, Product product) {
        Query query = new Query().addCriteria(Criteria.where("id").is(id));
        Update update = new Update().set("name",product.getName());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Product.class);
        return updateResult.getModifiedCount();
    }

}
