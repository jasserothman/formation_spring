package com.formation.app.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.formation.app.Dto.ProviderDto;
import com.formation.app.dao.ProviderDao;
import com.formation.app.entities.Provider;

import com.formation.app.service.ProviderService;

@Controller
public class ProviderController {


	@Autowired
	ProviderService providerService;
	@Autowired
	ProviderDao providerDao;

	
	@RequestMapping(value = "/providers", method = RequestMethod.GET)
	
	public String getAllProviders(Model model) {
		List<Provider> providers=providerService.getAll();
		model.addAttribute("providers",providers);
		return "providers";
	}
	@RequestMapping(value = "/addprovider", method = RequestMethod.GET)
	
	public String addProviders(Model model) {
		ProviderDto p = new ProviderDto();
		model.addAttribute("provider",p);
	
		return "addprovider";
	}
	
	
	@RequestMapping(value = "/saveprovider", method = RequestMethod.POST)
	public String saveProviderInfo(@Valid @ModelAttribute("provider") Provider provider, Errors erros) {
		if (erros.hasErrors()) {
			return "addprovider";
		} else {
			providerDao.save(provider);
			return "redirect:/providers";
		}

	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editProviderInfo(@RequestParam long id,Model model) {
		Provider provider=providerDao.findOne((long) id);
	model.addAttribute("provider",provider);
		return"edit-provider";
		
	}
	

	@RequestMapping(value="/update-provider",method=RequestMethod.POST)
	public String updateProvider(Provider provider, @RequestParam long id) {
	
		Provider foundProvider = providerService.getProviderById(id);
		
		foundProvider.setName(provider.getName());
		foundProvider.setSurname(provider.getSurname());
		foundProvider.setPhone(provider.getPhone());
		foundProvider.setAdress(provider.getAdress());
		foundProvider.setActive(provider.getActive());
		
		providerService.updateProvider(foundProvider);
	 	return "redirect:/providers";	
	}
	

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteProviderInfo(@RequestParam  long id) {
		providerService.deleteProviderById(id);

		return"redirect:/providers";
		
	}

}

