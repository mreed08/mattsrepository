package com.barista.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.barista.entity.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> { 
	
   
	
	Ingredient findByName(String name);
	
	@Modifying
	@Transactional
	@Query("UPDATE Ingredient i set i.inventoryCount = i.inventoryMax")
	void replenishInventory();
	

	
	@Modifying
	 @Transactional
	 @Query("UPDATE Ingredient i set i.inventoryCount = i.inventoryCount - :ingredientAmount "
	 		+ "WHERE i.name = :name ")
	 void updateInventory(@Param("name") String name,@Param("ingredientAmount") int ingredientAmount);
	
}