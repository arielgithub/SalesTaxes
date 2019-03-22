package org.organizzation.singleton;

import java.util.HashMap;
import java.util.Map;

import org.organizzation.constants.Constants;
import org.organizzation.enums.ProductTypes;

public class ProductCategory {
	
	private static ProductCategory single_instance = null;  
	private Map<String, ProductTypes> categories = new HashMap<String, ProductTypes>();

    private ProductCategory(){
    	this.categories.put("book", ProductTypes.BOOKS);
    	this.categories.put("music CD", ProductTypes.GENERICS);
    	this.categories.put("chocolate", ProductTypes.FOOD);
    	this.categories.put("bottle of perfume", ProductTypes.GENERICS);
    }
    
    public Map<String, ProductTypes> getCategories() {
    	return this.categories;
    }
  
    public static ProductCategory getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new ProductCategory(); 
  
        return single_instance; 
    } 

}
