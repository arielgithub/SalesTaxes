package org.organizzation.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Receipt {

	private List<BasketItem> items;
	private Basket basket;
	
	public Receipt() {
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public List<BasketItem> getItems() {
		return items;
	}

	public void setItems(List<BasketItem> items) {
		this.items = items;
	}
	
	public BigDecimal getTotalCost() {
		BigDecimal total = new BigDecimal(0);
		
		for (BasketItem bi : this.items) {
			total = total.add(bi.getTotalWithTax());
		}
		
		return total;
	}
	
	
	public void printItemsAndTotal() {		
		for (BasketItem bi : this.items) {
			System.out.println(bi.toString());
		}
	}
	
	public void printTotalCost(){
		System.out.println("Total: "+this.getTotalCost().setScale(2, RoundingMode.HALF_UP));
	}
	
}
