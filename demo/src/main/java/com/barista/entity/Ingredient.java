package com.barista.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Table;
@Entity
@Getter
@Setter
@Table(name = "ingredient")
public class Ingredient {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int inventoryCount;
	private double cost;
	private int inventoryMax;
	
	public Ingredient() {
		
	}
	
	public Ingredient(Long id, String name, int inventoryCount, double cost, int inventoryMax) {
		this.id = id;
		this.name = name;
		this.inventoryCount = inventoryCount;
		this.cost = cost;
		this.inventoryMax = inventoryMax;
	}
	
	 @Override
	   public String toString() {
	       return name+","+inventoryCount;
	   }
}
