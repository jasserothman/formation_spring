package com.formation.app.service;

import java.util.List;

import com.formation.app.entities.Product;
import com.formation.app.entities.Provider;
import com.formation.app.enums.ProviderClassificationEnum;
import com.formation.app.enums.ProviderStatus;


public interface ProviderService {

	Provider getProviderById(long id);

	List<Provider> getAll();

	Provider getProviderByProduct(Product product);

	Provider add(Provider provider);

	Provider updateStatus(Provider provider, ProviderStatus providerStatus);

	
	ProviderClassificationEnum getProviderClassification(Provider provider);

Provider updateProvider(Provider foundProvider);
void deleteProviderById(long id);




}
