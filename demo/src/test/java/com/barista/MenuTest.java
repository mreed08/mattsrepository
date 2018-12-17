package com.barista;

import static org.junit.Assert.*;

import org.junit.Test;

import com.barista.entity.Ingredient;
import com.barista.entity.Menu;

public class MenuTest {

Menu menu = new Menu();
Ingredient ingredient = new Ingredient();
Long id = (long) 1;
	@Test
	public void testGetMenuName() {
		menu.setMenuName("Coffee");
		assert(menu.getMenuName() == "Coffee");
	}

	@Test
	public void testGetIngredient() {
		ingredient.setName("Coffee");
		ingredient.setCost(.75);
		ingredient.setInventoryCount(1);
		ingredient.setInventoryMax(1);
		ingredient.setId(id);
		menu.setIngredient(ingredient);
		assert(menu.getIngredient().getName() == "Coffee");
	}

	@Test
	public void testGetIngredientAmount() {
		menu.setIngredientAmount(1);
		assert(menu.getIngredientAmount() == 1);
	}

	

}
