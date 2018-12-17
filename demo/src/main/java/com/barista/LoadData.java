package com.barista;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.barista.entity.Ingredient;
import com.barista.entity.Menu;
import com.barista.repository.IngredientRepository;
import com.barista.repository.MenuRepository;

@Service
public class LoadData  {
	private Logger LOG = LoggerFactory.getLogger("Application");
	
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private IngredientRepository ingredientRepository;

	public boolean loadData() {
		
		
	try {

			ingredientRepository.save(new Ingredient(null,"Coffee",10,.75,10));
			ingredientRepository.save(new Ingredient(null, "Decaf Coffee",10,.75,10));
			ingredientRepository.save(new Ingredient(null, "Sugar",10,.25,10));
			ingredientRepository.save(new Ingredient(null, "Espresso",10,1.10,10));
			ingredientRepository.save(new Ingredient(null, "Cream",10,.25,10));
			ingredientRepository.save(new Ingredient(null, "Steamed Milk",10,.35,10));
			ingredientRepository.save(new Ingredient(null, "Foamed Milk",10,.35,10));
			ingredientRepository.save(new Ingredient(null, "Cocoa",10,.90,10));
			ingredientRepository.save(new Ingredient(null, "Whipped Cream",10,1.00,10));
			  
			menuRepository.save(new Menu(null, "CAFE AMERICANO", ingredientRepository.findByName("Espresso"),3));
		 	menuRepository.save(new Menu(null, "COFFEE", ingredientRepository.findByName("Coffee"),3));
		 	menuRepository.save(new Menu(null, "COFFEE", ingredientRepository.findByName("Sugar"),1));
		    menuRepository.save(new Menu(null, "COFFEE", ingredientRepository.findByName("Cream"),1));
		    menuRepository.save(new Menu(null, "DECAF COFFEE", ingredientRepository.findByName("Decaf Coffee"),3));
		    menuRepository.save(new Menu(null, "DECAF COFFEE", ingredientRepository.findByName("Sugar"),1));
		    menuRepository.save(new Menu(null, "DECAF COFFEE", ingredientRepository.findByName("Cream"),1));
		    menuRepository.save(new Menu(null, "CAFFE LATTE", ingredientRepository.findByName("Espresso"),2));
		    menuRepository.save(new Menu(null, "CAFFE LATTE", ingredientRepository.findByName("Steamed Milk"),1));
		    menuRepository.save(new Menu(null, "CAFFE MOCHA", ingredientRepository.findByName("Espresso"),1));
		    menuRepository.save(new Menu(null, "CAFFE MOCHA", ingredientRepository.findByName("Cocoa"),1));
		    menuRepository.save(new Menu(null, "CAFFE MOCHA", ingredientRepository.findByName("Steamed Milk"),1));
		    menuRepository.save(new Menu(null, "CAFFE MOCHA", ingredientRepository.findByName("Whipped Cream"),1));
		    menuRepository.save(new Menu(null, "CAPPUCCINO", ingredientRepository.findByName("Espresso"),2));
		    menuRepository.save(new Menu(null, "CAPPUCCINO", ingredientRepository.findByName("Steamed Milk"),1));
		    menuRepository.save(new Menu(null, "CAPPUCCINO", ingredientRepository.findByName("Foamed Milk"),1));
		      
    } catch (DataAccessException ex) {
    	LOG.error("Loading Data on Startup Failed");
    	LOG.error(ex.getLocalizedMessage());
        return false;
    }
    return true;
	}
}
