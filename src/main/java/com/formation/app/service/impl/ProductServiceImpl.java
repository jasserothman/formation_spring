package com.formation.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.formation.app.dao.ProductDao;
import com.formation.app.dao.ProviderDao;
import com.formation.app.entities.Product;
import com.formation.app.entities.Provider;
import com.formation.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private static final String NULL_PROVIDER_ERROR ="Error : Product is NULL ";
	
	@Resource
	ProviderDao providerDao;
	
	@Resource
	ProductDao productDao ;
	
	
	
	@Override
	public Product getProductById(long id) {
		return productDao.findOne(id);
		
	}

	@Override
	public List<Product> getAll() {
		
		return productDao.findAll();
	}

	@Override
	public Product getProductByProvider(Provider provider) {
	
		return productDao.getProductByProvider(provider);
	}

	@Override
	public Product add(Product product) {
		
		return productDao.save(product);
	}

	@Override
	public void deleteProductById(long id) {
	
		productDao.delete(id);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.save(product);
		
	}


}
