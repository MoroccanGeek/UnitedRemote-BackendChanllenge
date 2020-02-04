package com.saberhamza.entity;

import org.springframework.hateoas.RepresentationModel;

/**
 * 
 * @author Hamza SABER
 *
 */
public class Repository extends RepresentationModel<Repository>{
	
	/**
	 * Name of repository.
	 */
	private String name;
	
	/**
	 * Description of repository.
	 */
	private String description;
	
	/**
	 * Link to repository.
	 */
	private String html_url;
	
	/**
	 * no-args constructor.
	 */
	public Repository() {
	}

	/**
	 * Constructor for Repository class.
	 * @param name Name of repository
	 * @param description Description of repository
	 * @param html_url Link to repository
	 */
	public Repository(String name, String description, String html_url) {
		this.name = name;
		this.description = description;
		this.html_url = html_url;
	}
	
	/*
	 * Getters & Setters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	
}