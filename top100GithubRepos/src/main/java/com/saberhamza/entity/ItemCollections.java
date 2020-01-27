package com.saberhamza.entity;

import java.util.List;

public class ItemCollections {
	
	private List<Item> items;

	public ItemCollections() {
	}

	public ItemCollections(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}