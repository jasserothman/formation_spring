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
import com.formation.app.enums.ProviderClassificationEnum;
import com.formation.app.enums.ProviderStatus;
import com.formation.app.service.ProviderService;



@Service
public class ProviderServiceImpl implements ProviderService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProviderServiceImpl.class);
	
	private static final String NULL_PROVIDER_ERROR ="Error : Provider is NULL ";
	
	@Resource
	ProviderDao providerDao;
	
	@Resource
	ProductDao productDao ;

	@Override
	public Provider getProviderById(long id) {
		return providerDao.findOne(id);
	}

	@Override
	public List<Provider> getAll() {
		return providerDao.findAll();
	}

	@Override
	public Provider getProviderByProduct(Product product) {
		return providerDao.getProviderByProducts(product);
	}

	@Override
	public Provider add(Provider provider) {
		return providerDao.save(provider);
	}
	

	
	/**
	 * Mise à jour du statut du fournisseur
	 * @return Provider
	 * @exception IOException
	 */
	@Override
	public Provider updateStatus(Provider provider, ProviderStatus providerStatus) {
		if(provider != null) {
			//Mise à jour status
			provider.setProviderStatus(providerStatus);
			//Sauvegarder dans la BD
			this.providerDao.save(provider);
		} else {
			LOGGER.error(NULL_PROVIDER_ERROR);
		}	
		return provider;
	}

	@Override
	public ProviderClassificationEnum getProviderClassification(Provider provider) {
		ProviderClassificationEnum result = null;
		if(provider != null) {
			//normal treatment
			final long productsTotal = productDao.countByProvider(provider);
			if(productsTotal <= 5) {
				if(productsTotal < 2) {
					result = ProviderClassificationEnum.SILVER;
				} else {
					result = ProviderClassificationEnum.GOLD;
				}
			} else {
				result = ProviderClassificationEnum.PREMIUM;
			}
		}else {
			LOGGER.error(NULL_PROVIDER_ERROR);
		}
		return result;
	}

	@Override
	public Provider updateProvider(Provider provider) {
		providerDao.save(provider);
		return null;
	}

	@Override
	public void deleteProviderById(long id) {
		providerDao.delete(id);
		
		
	}



}
