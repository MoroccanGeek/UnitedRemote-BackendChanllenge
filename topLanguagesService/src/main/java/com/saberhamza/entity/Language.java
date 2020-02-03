package com.saberhamza.entity;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Language extends RepresentationModel<Language>{
	
	private String name;
	
	private int stars;
	
	private int numberOfRepos;

	public Language() {
	}

	public Language(String name, int stars, int numberOfRepos, List<Repository> repos) {
		this.name = name;
		this.stars = stars;
		this.numberOfRepos = numberOfRepos;
	}
	
	public Language(String name, int stars, int numberOfRepos) {
		this.name = name;
		this.stars = stars;
		this.numberOfRepos = numberOfRepos;
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

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getNumberOfRepos() {
		return numberOfRepos;
	}

	public void setNumberOfRepos(int numberOfRepos) {
		this.numberOfRepos = numberOfRepos;
	}

}
