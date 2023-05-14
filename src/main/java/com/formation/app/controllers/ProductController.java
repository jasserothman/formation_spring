package com.formation.app.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.formation.app.Dto.ProductDto;
import com.formation.app.dao.ProductDao;
import com.formation.app.entities.Product;
import com.formation.app.entities.Provider;
import com.formation.app.enums.StatusEnum;
import com.formation.app.service.ImportQuantitiesService;
import com.formation.app.service.ProductService;
import com.formation.app.service.ProviderService;


@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	ProductDao productDao;
	@Autowired
	ProviderService providerService;
	
	@Autowired
	ImportQuantitiesService importQuantitiesService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)

	public String getAllProducts(Model model) {
		List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		return "products";
	}
	
	
	
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.GET)
	
	public String addProducts(Model model) {
		ProductDto product = new ProductDto();
		model.addAttribute("product",product);
		List<Provider> providers = this.providerService.getAll();
		model.addAttribute("providers",providers);
		return "addproduct";

		}
	
	
	@RequestMapping(value = "/provider-info", method = RequestMethod.GET)
	
	public String providerinfo(@RequestParam long id,Model model) {
		
		
		Provider providers = this.providerService.getProviderById(id);
		model.addAttribute("providers",providers);
		return "provider-info";

		}
	
@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
public String saveProducts(@Valid @ModelAttribute("product") Product product,Errors erros,HttpServletRequest httpRequest,Model model) {
	
	final long providerId = Integer.parseInt(httpRequest.getParameter("id-provider"));
	final Provider provider = this.providerService.getProviderById(providerId);
	product.setProvider(provider);
	
	List<Provider> providers = this.providerService.getAll();
	model.addAttribute("providers",providers);
	if(erros.hasErrors()) {
		
			return "addproduct";
		} else {
		
			productDao.save(product);
			
		
			return "redirect:/products";
		}
		
	

		}
	
	@RequestMapping(value="/edit-product",method=RequestMethod.GET)
	public String editProductInfo(@RequestParam long id,Model model) {
		Product product=productDao.findOne(id);
	model.addAttribute("product",product);
	List<Provider> providers = this.providerService.getAll();
	model.addAttribute("providers",providers);
		return"edit-product";
		
	}
	
	@RequestMapping(value="/update-product",method=RequestMethod.POST)
	public String updateProduct(@Valid  @ModelAttribute("product")Product product,Errors erros2, @RequestParam long id ,Model model) {
	
		Product foundProduct = productService.getProductById(id);
		
		
		foundProduct.setName(product.getName());
		foundProduct.setQuantity(product.getQuantity());
		foundProduct.setDescription(product.getDescription());
		foundProduct.setIsOnSell(product.getIsOnSell());
		foundProduct.setIsAvailable(product.getIsAvailable());
		
		
		List<Provider> providers = this.providerService.getAll();
		model.addAttribute("providers",providers);
		
		if (erros2.hasErrors()) {
		return "edit-product";	
		}else
		{
			productService.updateProduct(foundProduct);
			
			
			
			return "redirect:/products";	
		}
	
	}
	
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	
	public String deleteProductInfo(@PathVariable long id) {
		productService.deleteProductById(id);
		return "redirect:/products";

		}
	
	
	@RequestMapping(value = "/importProducts", method = RequestMethod.GET)
	@ResponseBody
	public List<String> ImportProducts() {
		
		final Map<StatusEnum, List<String>> reportMap = this.importQuantitiesService.updateQuantities("E:\\workspaceSpringBoot\\formation_spring\\input.csv");
		final Collection<List<String>> reports = reportMap.values();
		final List<String> result = new ArrayList<String>();
		for (List<String> report : reports) {
			result.addAll(report);
		}
		return result;
	}
	
	
	}
