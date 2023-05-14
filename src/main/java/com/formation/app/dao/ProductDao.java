package com.formation.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.app.entities.Product;
import com.formation.app.entities.Provider;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> , CrudRepository<Product, Long> {
	long countByProvider(Provider provider);
	Product getProductByProvider(Provider provider);
	Product getProductByReference(String reference);

}
