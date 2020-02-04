package com.saberhamza.entity;

import java.util.List;

/**
* ItemCollections is Collection contains list of items.
* 
* @author Hamza SABER
* 
*/
public class ItemCollections {
	
	/**
	 * List of items.
	 */
	private List<Item> items;

	/**
	 * no-args constructor.
	 */
	public ItemCollections() {
	}

	/**
	 * Constructor for ItemCollections class.
	 * 
	 * @param items List of items
	 */
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