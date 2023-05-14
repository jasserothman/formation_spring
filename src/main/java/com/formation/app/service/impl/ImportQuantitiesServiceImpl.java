package com.formation.app.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.formation.app.dao.ProductDao;
import com.formation.app.entities.Product;
import com.formation.app.enums.StatusEnum;
import com.formation.app.service.ImportQuantitiesService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class ImportQuantitiesServiceImpl implements ImportQuantitiesService{
	private static final Logger LOGGER = LoggerFactory.getLogger(ImportQuantitiesServiceImpl.class);

	private static final String QUANTITY_FIELD_ERROR = "Format du champs quantité invalide";

	private static final String FILE_ERROR = "problèmes lors du traitement du fichier";

	private static final String SUBJECT = "Import Quantities Report";

	@Resource
	ProductDao productDao;

	@Autowired
	JavaMailSender mailSender;

//	@Value("${quantities.report.recipients}")
//	String recipients;

	@Override
	public Map<StatusEnum,List<String>> updateQuantities(String path) {
		final Map<StatusEnum, List<String>> reportMap = new HashMap<StatusEnum, List<String>>();
	
		try {
			
			final List<String> success = new ArrayList<String>();
			final List<String> failed = new ArrayList<String>();
			final CSVReader csvReader = new CSVReader(new FileReader(path));
			final List<List<String>> records = this.extractData(csvReader);
			
			Product product;
			String reference;
			String quantity;
			int effectiveQuantity;
		
			for (List<String> record : records) {
				reference = record.get(0);
				quantity = record.get(1);
				if (StringUtils.isNotBlank(reference) && StringUtils.isNotBlank(quantity)) {
					try {
						effectiveQuantity = Integer.parseInt(quantity);
						product = this.productDao.getProductByReference(reference);
						if(product!= null) {
							product.setQuantity(effectiveQuantity);
							product.setProvider(null);
							this.productDao.save(product);
							success.add(reference);
						} else {
							failed.add(reference);
						}
					
					} catch (NumberFormatException ex) {
						LOGGER.error(QUANTITY_FIELD_ERROR, ex);
						failed.add(reference);
					}
				}
			}
			reportMap.put(StatusEnum.SUCCESS, success);
			reportMap.put(StatusEnum.FAILED, failed);
		//	this.sendReport(reportMap);
			Thread thread = new Thread(() -> this.sendReport(reportMap));
			thread.start();

		} catch (FileNotFoundException ex) {
			LOGGER.error(FILE_ERROR, ex);
		} catch (CsvValidationException ex) {
			LOGGER.error(FILE_ERROR, ex);
		} catch (IOException ex) {
			LOGGER.error(FILE_ERROR, ex);
		}return reportMap;
	}

	private List<List<String>> extractData(CSVReader csvReader) throws CsvValidationException, IOException {
		List<List<String>> result = new ArrayList<List<String>>();
		String[] line;
		while ((line = csvReader.readNext()) != null) {
			result.add(Arrays.asList(line));
		}
		
		return result;
	}

	private void sendReport(Map<StatusEnum, List<String>> map) {
		final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject(SUBJECT);
		final StringBuilder builder = new StringBuilder();
		map.forEach((k, v) -> {
			if (StatusEnum.SUCCESS.equals(k)) {
				for (String value : v) {
					builder.append("Référence : ").append(value).append(" avec succés \n");
				}
			} else {
				for (String value : v) {
					builder.append("Référence : ").append(value).append(" n'est pas importée \n");
				}
			}
		});
		// Set Content
		simpleMailMessage.setText(builder.toString());
		// Récup des destinataires
		//final List<String> recipientsList = Arrays.asList(recipients.split(","));
		//for (String recipient : recipientsList) {
			simpleMailMessage.setTo("jasserothman9@gmail.com");
			mailSender.send(simpleMailMessage);
		//}

	
	}
	}
