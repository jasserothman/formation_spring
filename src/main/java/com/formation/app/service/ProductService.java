package com.formation.app.service;

import java.util.List;

import com.formation.app.entities.Product;
import com.formation.app.entities.Provider;


public interface ProductService {

	Product getProductById(long id);

	List<Product> getAll();

	Product getProductByProvider(Provider provider);
	Product add(Product product);
	void deleteProductById(long id); 
	void updateProduct(Product product);

}
