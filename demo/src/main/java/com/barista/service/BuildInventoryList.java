package com.barista.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.barista.repository.IngredientRepository;

@EnableJpaRepositories
public class BuildInventoryList {

	
	@Autowired
	private IngredientRepository ingredientRepository;
	@Bean
	public boolean getIngredientInventoryList() {
	
		ingredientRepository.findAll();
	
		return true;
	}
	

}
