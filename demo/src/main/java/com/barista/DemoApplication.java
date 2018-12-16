package com.barista;

import com.barista.DTO.MenuOutputDTO;
import com.barista.DTO.MenuOutputIngredientAndAmountDTO;
import com.barista.entity.Ingredient;
import com.barista.entity.Menu;


import com.barista.repository.IngredientRepository;
import com.barista.repository.MenuRepository;
import com.barista.service.ApplicationServices;
import com.barista.service.BuildInventoryList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.TreeMap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.summingLong;

import java.text.DecimalFormat;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;
@EnableJpaRepositories
@SpringBootApplication
@Profile("!test")
public class DemoApplication implements CommandLineRunner {
	private Logger LOG = LoggerFactory.getLogger("Application");

	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private ApplicationServices applicationServices;
	@Autowired
	private LoadData loadData;
	
  
    public static void main(String[] args) throws Exception {

     
        SpringApplication app = new SpringApplication(ExecuteProgram.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

   }
  
    @Override
    public void run(String... args) throws Exception {
   	 	
    	boolean loadDataResult = loadData.loadData(ingredientRepository, menuRepository);
    	if (!loadDataResult) {
    		System.out.println("Loading of data on startup failed, please contact System Admin, call 867-5309");
    		System.exit(0);
    	}
    	       
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