package com.niit.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.niit.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findAllByAvailableIgnoreCase(String string);

}
