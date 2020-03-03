package com.mocha.dto;

/**
 * 
 * @author KOZHI
 * Cart class - Cart Bean     
 *
 */ 

public class Cart {

	private int CartNo;
	private int itemId;
	private String itemName;
	private String customerId;
	private String shoesize;
	private int quantity;
	private double price;
	
	public int getCartNo() {
		return CartNo;
	}
	public void setCartNo(int cartNo) {
		CartNo = cartNo;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
 
	public String getShoesize() {
		return shoesize;
	}
	public void setShoesize(String shoesize) {
		this.shoesize = shoesize;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
