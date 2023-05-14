//package com.formation.app.validators;
//
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//import com.formation.app.entities.Product;
//
//public class ProductValidator implements Validator {
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		// TODO Auto-generated method stub
//		return Product.class.equals(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//		// TODO Auto-generated method stub
//		Product product = (Product) target;
//		ValidationUtils.rejectIfEmpty(errors, "name", "Champ Obligatoire");
//		if(product.getName().length()<2) {
//			errors.rejectValue("name", "Longueur inferieur a deux");
//		}
//	}
//
//}
