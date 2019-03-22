package org.organizzation.business;

import java.math.BigDecimal;

import org.organizzation.model.Basket;
import org.organizzation.model.BasketItem;
import org.organizzation.model.Item;
import org.organizzation.model.Receipt;

public class ShopController {
	
	private Basket basket;
	
	public ShopController() {
		this.basket = new Basket();
	}
	
	public void addProductToBasket(String nome, Integer quantity, BigDecimal price, Boolean imported) {
		Item item = new Item();
		item.setName(nome);
		item.setPrice(price);
		item.setImported(imported);
		
		BasketItem bi = new BasketItem(item, quantity);
		this.basket.addToBasket(bi);
	}
	
	public void cleanBasket() {
		this.basket.clearBasket();
	}
	
	public Receipt generateReceipt() {
		Receipt receipt = new Receipt();
		receipt.setItems(this.basket.getItems());
		
		return receipt;
	}
	
}
