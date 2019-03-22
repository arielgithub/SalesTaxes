package org.organizzation.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import org.organizzation.constants.Constants;
import org.organizzation.enums.ProductTypes;
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
		Map<String, ProductTypes> categories = pc.getCategories();
		
		if(categories.get(this.getName()) == ProductTypes.BOOKS || 
				categories.get(this.getName()) == ProductTypes.FOOD ||
					categories.get(this.getName()) == ProductTypes.MEDICAL) {
			
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
		String itemS = "Item: "+this.quantity+" "+this.getName();
		String importedS = this.getImported() ? " - imported " : "";
		String totalS = " - Total: "+this.getTotalWithTax().setScale(2, RoundingMode.HALF_UP);
		return  itemS+importedS+totalS;
	}

}
