package com.barista.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.barista.DTO.MenuOutputDTO;
import com.barista.DTO.MenuOutputIngredientAndAmountDTO;
import com.barista.entity.Menu;

	@Repository
	public interface MenuRepository extends JpaRepository<Menu, Long> { 
		
		
		 Menu findByMenuName(String menuName);
		 List<Menu> findIngredientByMenuName(String menuName);
		
		 
		 
    	 @Query("SELECT DISTINCT(m.menuName), m.ingredient FROM Menu m")
			  List<String> findDistinctMenuName();
			
    	 @Query("SELECT DISTINCT m.ingredient.name FROM Menu m ")
			  List<String> findDistinctMenuIngredients();
    	
    	 @Query("SELECT  m.ingredient.name, m.ingredientAmount FROM Menu m where m.menuName = :menuName")
		  List<MenuOutputIngredientAndAmountDTO> findDistinctIngredientByMenuName(@Param("menuName") String menuName);
 
    
    	 
    	 @Query("SELECT new com.barista.DTO.MenuOutputDTO(m.menuName as menuName ,"
    	 		+ " sum(m.ingredient.cost * m.ingredientAmount) as cost"
    	 		+ ", CASE WHEN (m.ingredientAmount <= m.ingredient.inventoryCount) THEN true "
    	 		+ "ELSE false END as inStock) "
    	 		+ "FROM Menu m "
    	 		+ "group by m.menuName, m.ingredientAmount,m.ingredient.inventoryCount " 
    	 		+ "order by m.menuName ASC")
    	  List<MenuOutputDTO> findNameAndIngredientDTO();
    	 
   
    	 
    	 @Query("SELECT CASE WHEN (COUNT(*) > 0) THEN false ELSE true END "
      	 		+ "FROM Menu m WHERE m.menuName = :menuName"
      	 		+ " and m.ingredientAmount > m.ingredient.inventoryCount")
     	 boolean findOutOfStockByDrink(@Param("menuName") String menuName);
    	 
    	 
 
    	 
	}