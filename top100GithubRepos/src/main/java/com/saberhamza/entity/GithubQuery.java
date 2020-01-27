package com.saberhamza.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubQuery {
	
	private String total_count;
	
	private String incomplete_results;
	
	private List<Item> items;

	public GithubQuery() {
	}

	public GithubQuery(String total_count, String incomplete_results, List<Item> items) {
		super();
		this.total_count = total_count;
		this.incomplete_results = incomplete_results;
		this.items = items;
	}

	/*
	 * Getters & Setters
	 */
	public String getTotal_count() {
		return total_count;
	}

	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}

	public String getIncomplete_results() {
		return incomplete_results;
	}

	public void setIncomplete_results(String incomplete_results) {
		this.incomplete_results = incomplete_results;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Repository [total_count=" + total_count + ", incomplete_results=" + incomplete_results + ", items="
				+ items + "]";
	}
	
	
	
	
}