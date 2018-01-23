package com.lei.demo.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {

	@Value("#{itemBean}")
	private Item item;

	@Value("#{itemBean.name}")
	private String itemName;

	public Item getItem() {
		return item;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	//////////////////////////
	@Value("#{'lei'.toUpperCase()}")
	private String name;

	@Value("#{priceBean.getSpecialPrice()}")
	private double amount;

	// getter and setter...省略

	@Override
	public String toString() {
		return "Customer [name=" + name + ", amount=" + amount + "]";
	}

}