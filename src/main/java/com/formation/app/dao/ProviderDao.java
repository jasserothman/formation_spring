package com.formation.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.app.entities.Product;
import com.formation.app.entities.Provider;

@Repository
public interface ProviderDao extends JpaRepository<Provider, Long> , CrudRepository<Provider, Long>{
	
	Provider getProviderByProducts(Product product);
	
	Provider getProviderByName(String name);


	
}
