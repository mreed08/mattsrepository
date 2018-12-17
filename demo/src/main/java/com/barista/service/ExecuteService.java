package com.barista.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.barista.DTO.MenuOutputDTO;
import com.barista.entity.Ingredient;
import com.barista.repository.IngredientRepository;
import com.barista.repository.MenuRepository;

@Service
public class ExecuteService {
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private ApplicationServices applicationServices;

	
	public void processMain()  {
	String userInput;
 	DecimalFormat dec = new DecimalFormat("#.00");
 	
 	Scanner sn = new Scanner(System.in);
 		
 	while(true){
  	    System.out.println("INVENTORY:");	
	  	    for (Ingredient ingredient : ingredientRepository.findAll(new Sort(Sort.Direction.ASC, "name"))) {
	 			System.out.println(ingredient.toString());				
	  	    }
	
	  	System.out.println("MENU:");
 	
	  	List<MenuOutputDTO> menuOutputDTOs = menuRepository.findNameAndIngredientDTO();   	
	  	Map<String, Double> result = menuOutputDTOs.stream().collect(groupingBy(MenuOutputDTO::getMenuName, TreeMap::new, summingDouble(MenuOutputDTO::getCost)));     	
	  	int i = 0;
 		     
	  	for (Map.Entry<String, Double> output : result.entrySet()) {
	  		i++;
	  		System.out.println(i +"." +output.getKey() + ",$" + dec.format(output.getValue()) + ","+menuRepository.findOutOfStockByDrink(output.getKey()));
	    
	  	}	
	  	userInput = sn.next();
	  	boolean isNumber = applicationServices.isNumber(userInput);
	  	String menuName = "";
	  	
	  	System.out.println("userinput-->"+userInput);
	  	
	  	//dynamic generation of menu list 
	  	if (isNumber && Integer.parseInt(userInput) <= i && Integer.parseInt(userInput) >0) {
	  		int inputValue = Integer.parseInt(userInput) -1 ;
	  		menuName = menuOutputDTOs.get(inputValue ).getMenuName();  		
	  		if (menuRepository.findOutOfStockByDrink(menuName)) {
 					menuRepository.findIngredientByMenuName(menuName).forEach(item->
 					ingredientRepository.updateInventory(item.getIngredient().getName(), item.getIngredientAmount()));
 					System.out.println("DISPENSING: "+ menuName);
 				}
	  		else {System.out.println("OUT OF STOCK: "+ menuName);}
		}
 	
	  	else if (!isNumber && userInput.equalsIgnoreCase("q")) {
	  		System.out.println("Exiting...");
	  		sn.close();
	  		System.exit(0);
 		}
	  	else if (!isNumber && userInput.equalsIgnoreCase("r")) {
	  		ingredientRepository.replenishInventory();
			
	  	}
	  	else {
	  		System.out.println("Invalid selection: " + userInput);
 		}
 	
 	}
 
 	
	}
	
	
}
