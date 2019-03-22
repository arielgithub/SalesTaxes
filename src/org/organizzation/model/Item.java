package org.organizzation.model;

import java.math.BigDecimal;

public class Item {
	
	private String name;
	private BigDecimal price;
	private Boolean imported;
	private String type;
	
	public Item() {
	}
	
	public Item(String name, BigDecimal price, Boolean imported) {
		this.name = name;
		this.price = price;
		this.imported = imported;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Boolean getImported() {
		return imported;
	}

	public void setImported(Boolean imported) {
		this.imported = imported;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
