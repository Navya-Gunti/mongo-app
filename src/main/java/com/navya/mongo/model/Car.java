package com.navya.mongo.model;

import org.springframework.data.annotation.Id;

public class Car {

	private String description;
	private float price;
	 @Id
	 public String id;
	private String brand;
	
	private String itemId;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return String.format("Car[id=%s, decription='%s', model='%s']", id, description, brand);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setModel(String brand) {
		this.brand = brand;
	}

}
