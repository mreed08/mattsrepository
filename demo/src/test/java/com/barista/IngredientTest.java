package com.barista;

import static org.junit.Assert.*;

import org.junit.Test;

import com.barista.entity.Ingredient;

public class IngredientTest {
	
	Ingredient ingredient = new Ingredient();

	@Test
	public void testGetName() {
		ingredient.setName("Cream");
		assert(ingredient.getName().equals("Cream"));
	
	}

	@Test
	public void testGetInventoryCount() {
		ingredient.setInventoryCount(1);
		assert(ingredient.getInventoryCount() == 1);
	}

	@Test
	public void testGetCost() {
	    ingredient.setCost(0.75);
		assert(ingredient.getCost() == 0.75);
	}

	@Test
	public void testGetInventoryMax() {
		ingredient.setInventoryMax(1);
		assert(ingredient.getInventoryMax() == 1);
	}

	
}
