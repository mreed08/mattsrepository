package com.barista;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.barista.repository.IngredientRepository;
import com.barista.repository.MenuRepository;



public class LoadDataTest {

	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private IngredientRepository ingredientRepository;	
	
	LoadData loadData = new LoadData();
	@Test
	public void test() {
	
		assert(true);
	}

}
