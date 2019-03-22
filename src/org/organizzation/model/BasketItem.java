package org.organizzation.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import org.organizzation.constants.Constants;
import org.organizzation.singleton.ProductCategory;

public class BasketItem extends Item {
	
	private Integer quantity;
	
	public BasketItem(Item item, Integer quantity) {
		
		super(item.getName(), item.getPrice(), item.getImported());
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getTotalWithTax() {
		BigDecimal subTotal = this.getPriceWithTax().multiply(new BigDecimal(this.getQuantity()));
		return subTotal;
	}
	
	public BigDecimal getPriceWithTax() {
		BigDecimal subTotal = this.getPrice();
		
		ProductCategory pc = ProductCategory.getInstance();
		Map<String, String> categories = pc.getCategories();
		
		if(categories.get(this.getName()) == Constants.BOOKS || 
				categories.get(this.getName()) == Constants.FOOD ||
					categories.get(this.getName()) == Constants.MEDICAL) {
			
			BigDecimal taxes = this.getPrice().multiply(Constants.BASIC_SALE_TAX).divide(Constants.HUNDRED);
			subTotal = subTotal.add(taxes);
			
		}
		
		if(this.getImported()) {
			BigDecimal dutyTaxes = this.getPrice().multiply(Constants.DUTY_TAX).divide(Constants.HUNDRED);
			subTotal = subTotal.add(dutyTaxes);
		}
		
		return subTotal;
	}
	
	@Override
	public String toString() {
		return "Item name: "+this.getName()+" - Total: "+this.getTotalWithTax().setScale(2, RoundingMode.HALF_UP);
	}

}
