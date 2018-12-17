package com.barista.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.barista.repository.IngredientRepository;

public class Replenish {
	@Autowired
	private IngredientRepository ingredientRepository;

	
	public void replenishInventory(){
		ingredientRepository.replenishInventory();
	}
}
