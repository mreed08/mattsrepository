package com.barista.entity;

import java.text.DecimalFormat;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Menu {
	@Id
	@GeneratedValue
	private Long id;
	private String menuName;

	@NonNull
	@ManyToOne
	private Ingredient ingredient;
	
	@NonNull
	private int ingredientAmount;

	
	
	public Menu() {
		
	}
	
	public Menu(Long id, String menuName, Ingredient ingredient, int ingredientAmount) {
		this.id = id;
		this.menuName = menuName;
		this.ingredient = ingredient;
		this.ingredientAmount = ingredientAmount;
	
	
	}
	
	
	 @Override
	   public String toString() {
		 DecimalFormat dec = new DecimalFormat("#.00");
	    // return menuName +"," $+ (Double.valueOf(dec.format(ingredient.getCost() * ingredientAmount)));
		 return menuName +", $"+ dec.format((Double.valueOf(ingredient.getCost() * ingredientAmount)));
	   }
}
