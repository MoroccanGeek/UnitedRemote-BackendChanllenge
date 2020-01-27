package com.saberhamza.entity;

import java.util.List;

public class LanguageCollections {
	
	private int ranksCount;
	
	private List<Language> trendingLanguages;

	public LanguageCollections() {
	}
	
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
