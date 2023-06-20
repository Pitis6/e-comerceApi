package com.felipe.ecomrecev1.repository.mongoRepository;

import com.felipe.ecomrecev1.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsMongoRepository extends MongoRepository<Product,String> {
}
