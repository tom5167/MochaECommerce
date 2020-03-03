package com.mocha.dto;

/**
 * Servlet implementation class LoginController
 */
/**
 * --------------------------------------------- 
 * @author KOZHI
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Mar 1, 2020 
 * modified Date : Mar 1, 2018
 * --------------------------------------------- 
 *
 * Page Task	: Shoes Bean     
 *
 */ 

public class Shoes {
 
    private int itemId;
	private String itemName;
	private String category;
	private String shoesize; 
	private int quantity;
	private double price;
	private String content;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getShoesize() {
		return shoesize;
	}
	public void setShoesize(String shoesize) {
		this.shoesize = shoesize;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
