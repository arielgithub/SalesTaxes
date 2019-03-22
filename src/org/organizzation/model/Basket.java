package org.organizzation.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	
    private List<BasketItem> items;
	
	public Basket() {
		this.items = new ArrayList<BasketItem>(); 
	}
	
	public void addToBasket(BasketItem item) {
		this.items.add(item);
	}
	
	public void clearBasket() {
		this.items.clear();
	}
	
	public List<BasketItem> getItems() {
		return this.items;
	}
		
}
