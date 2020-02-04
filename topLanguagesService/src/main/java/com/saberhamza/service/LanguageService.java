package com.saberhamza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saberhamza.entity.Item;
import com.saberhamza.entity.Language;

/**
 * 
 * @author Hamza SABER
 *
 */
@Service
public interface LanguageService {
	
	/**
	 * 
	 * @param top100Items top 100 github repositories
	 * 
	 * @return languages by total earned stars in descending order
	 */
	public List<Language> getTrendingLanguagesFrom(List<Item> topItems);

	/**
	 * 
	 * @param rankId language's rank
	 * @param top100Items top 100 github repositories
	 * 
	 * @return languages by total earned stars in descending order
	 */
	public Language getLanguageOfRank(int rankId, List<Item> top100Items);


}
