package com.saberhamza.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
	
	private String name;
	
	private String description;
	
	private String stargazers_count;
	
	private String language;
	
	private String html_url;

	public Item() {
	}

	public Item(String name, String description, String stargazers_count, String language, String html_url) {
		super();
		this.name = name;
		this.description = description;
		this.stargazers_count = stargazers_count;
		this.language = language;
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

	public String getStargazers_count() {
		return stargazers_count;
	}
	
	public int getStars() {
		return Integer.parseInt(stargazers_count);
	}

	public void setStargazers_count(String stargazers_count) {
		this.stargazers_count = stargazers_count;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Item other = (Item) obj;
		
		if (language == null) {
			if (other.language != null)
				return false;
		} 
		else if (!language.equals(other.language))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Item [lang=" + language + "]";
	}
	
	
	
}