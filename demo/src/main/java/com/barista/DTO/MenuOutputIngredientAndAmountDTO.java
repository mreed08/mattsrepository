package com.barista.DTO;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MenuOutputIngredientAndAmountDTO {
	   
	    private String name;
	   
	    private int ingredientAmount; 

	    public MenuOutputIngredientAndAmountDTO(String name, int ingredientAmount) {
	        this.name = name;
	        this.ingredientAmount = ingredientAmount;
	    
	    }

	
		@Override
		   public String toString() {
			
		     return name +","+ ingredientAmount;
		     
		   }
}
