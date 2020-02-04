package com.saberhamza.entity;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Language class holds information about a certain programming language.
 * 
 * @author Hamza SABER
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Language extends RepresentationModel<Language>{
	
	/**
	 * Name of the language.
	 */
	private String name;
	
	/**
	 * Total earned stars of this language.
	 */
	private int stars;
	
	/**
	 * Number of repositories using this language.
	 */
	private int numberOfRepos;

	/**
	 * no-args constructor.
	 */
	public Language() {
	}

	/**
	 * 
	 * Constructor for language class.
	 * 
	 * @param name name of the language
	 * @param stars stars earned
	 * @param numberOfRepos Number of repositories using this language.
	 * @param repos 
	 */
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
