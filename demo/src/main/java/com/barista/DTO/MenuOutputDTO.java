package com.barista.DTO;

import java.text.DecimalFormat;


public class MenuOutputDTO {
	   
	    private String menuName;
	    private double cost;
	    private boolean inStock; 

	    public MenuOutputDTO(String menuName, double cost, boolean inStock) {
	        this.menuName = menuName;
	        this.cost = cost;
	        this.inStock = inStock;
	    }

	

		 public String getMenuName() {
			return menuName;
		}



		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}


		public double getCost() {
			return cost;
		}



		public void setCost(double cost) {
			this.cost = cost;
		}



		public boolean isInStock() {
			return inStock;
		}



		public void setInStock(boolean inStock) {
			this.inStock = inStock;
		}



		@Override
		   public String toString() {
			 
			 DecimalFormat dec = new DecimalFormat("#.00");
		     return menuName +", $"+ 
					// ingredient.getName() +","+ 
		          dec.format(cost) +","+inStock;
		      // return menuName+","+cost;
		   }
}
