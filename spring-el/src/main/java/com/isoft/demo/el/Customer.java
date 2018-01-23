package com.isoft.demo.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Customer {

	
	private Item item;

	
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

}