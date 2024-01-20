package com.niit.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.product.model.Product;
import com.niit.product.repository.ProductRepository;

@Component
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	public boolean saveProducts(Product product) {
		productRepo.save(product);
		return true;
	}
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public boolean deleteProducts(String productCode) {
		productRepo.deleteById(productCode);
		return true;
	}
	
	public boolean updateProducts(Product product) {
		productRepo.deleteById(product.getProductCode());
		productRepo.save(product);
		return true;
	}

	public List<Product> getAllAvailableProducts() {
		return productRepo.findAllByAvailableIgnoreCase("Yes");
	}
}
