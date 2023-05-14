package com.formation.app.Dto;

public class ProductDto {

	
	private String name="name product";
	private int quantity=0;	
	private String description="description";
	private boolean isOnSell=false;
	private boolean isAvailable=false;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getisOnSell() {
		return isOnSell;
	}
	public void setisOnSell(boolean isOnSell) {
		this.isOnSell = isOnSell;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	
	

}
