package org.organizzation.singleton;

import java.util.HashMap;
import java.util.Map;

import org.organizzation.constants.Constants;

public class ProductCategory {
	
	private static ProductCategory single_instance = null;  
	private Map<String, String> categories = new HashMap<String, String>();

    private ProductCategory(){
    	this.categories.put("book", Constants.BOOKS);
    	this.categories.put("music CD", Constants.GENERICS);
    	this.categories.put("chocolate", Constants.FOOD);
    	this.categories.put("bottle of perfume", Constants.GENERICS);
    }
    
    public Map<String, String> getCategories() {
    	return this.categories;
    }
  
    public static ProductCategory getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new ProductCategory(); 
  
        return single_instance; 
    } 

}
