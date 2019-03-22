package org.organizzation.main;

import java.math.BigDecimal;

import org.organizzation.business.ShopController;
import org.organizzation.model.Receipt;

public class ShoppingMain {
	
	public static void main(String[] args) {
	
//		1 book at 12.49
//		1 music CD at 14.99
//		1 chocolate at 0.85
		
		System.out.println("Receipt1:");
		ShopController sc = new ShopController();
		sc.addProductToBasket("book", 1, new BigDecimal(12.49), false);
		sc.addProductToBasket("music CD", 1, new BigDecimal(14.99), false);
		sc.addProductToBasket("chocolate", 1, new BigDecimal(0.85), false);
		
		Receipt r1 = sc.generateReceipt();
		r1.printItemsAndTotal();
		
		sc.cleanBasket();
		
//		2 imported chocolate at 10.00
//		1 imported bottle of perfume at 47.50
		System.out.println("Receipt2:");
		sc.addProductToBasket("chocolate", 2, new BigDecimal(10.00), true);
		sc.addProductToBasket("bottle of perfume", 1, new BigDecimal(47.50), true);
		
		r1 = sc.generateReceipt();
		r1.printItemsAndTotal();

		
	}

}
