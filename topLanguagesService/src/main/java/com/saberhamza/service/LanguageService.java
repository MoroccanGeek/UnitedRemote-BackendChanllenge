package com.saberhamza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saberhamza.entity.Item;
import com.saberhamza.entity.Language;

@Service
public interface LanguageService {
	
	//Get languages by total earned stars in descending order
	public List<Language> getTrendingLanguagesFrom(List<Item> topItems);

	public Language getLanguageOfRank(int rankId, List<Item> top100Items);


}
