package com.ecommerce.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.product.ProductCategory;


@Repository
public interface ProductCategoryRepository extends MongoRepository<ProductCategory, Integer> {



}
