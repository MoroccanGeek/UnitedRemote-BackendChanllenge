package com.saberhamza.entity;

import java.util.List;

/**
 * Collection of trending languages on github.
 * 
 * @author Hamza SABER
 *
 */
public class LanguageCollections {
	
	/**
	 * Number of ranks.
	 */
	private int ranksCount;
	
	/**
	 * List of trending languages on github.
	 */
	private List<Language> trendingLanguages;

	/**
	 * no-args constructor
	 */
	public LanguageCollections() {
	}
	
	/**
	 * Constructor for LanguageCollections class
	 * 
	 * @param ranksCount Number of ranks.
	 * @param trendingLanguages List of trending languages on github.
	 */
	public LanguageCollections(int ranksCount, List<Language> trendingLanguages) {
		
		this.ranksCount = ranksCount;
		this.trendingLanguages = trendingLanguages;
	}
	
	/*
	 * Getters & Setters
	 */
	public int getRanksCount() {
		return ranksCount;
	}

	public void setRanksCount(int ranksCount) {
		this.ranksCount = ranksCount;
	}

	public List<Language> getTrendingLanguages() {
		return trendingLanguages;
	}

	public void setTrendingLanguages(List<Language> trendingLanguages) {
		this.trendingLanguages = trendingLanguages;
	}
	
}