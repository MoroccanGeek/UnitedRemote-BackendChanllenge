package com.saberhamza.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.saberhamza.entity.Item;
import com.saberhamza.entity.Language;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Service
public class LanguageServiceImpl implements LanguageService {

	//Get languages by total earned stars in descending order
	@Override
	public List<Language> getTrendingLanguagesFrom(List<Item> top100Items) {
		
		//Set of unique languages used in top 100 repos
		Set<String> top100LanguagesNames = top100Items.stream()
												.map(e -> e.getLanguage())
												.collect(Collectors.toSet());
		
		
		List<Language> top100Languages = new ArrayList<>();
		
		//loop around each language name
		top100LanguagesNames.forEach(e -> {
			
			//Supplier to get items with current programming language
			Supplier<Stream<Item>> tempItems = () -> top100Items.stream().filter(i -> i.getLanguage().equals(e));
			
			//Current language Name
			String langName = e;
			
			//Total Stars of the current programming language
			Integer totalStars = tempItems.get()
											  .map(i -> Integer.parseInt(i.getStargazers_count()))
											  .collect(Collectors.summingInt(Integer::intValue));
			
			//Number of Repositories among the top 100 using current programming language
			Integer reposCount = (int) tempItems.get().count();
			
			
			//List of repositories using current programming language
			//List<Repository> reposOfCurrentLanguage = getReposFrom(tempItems.get());
			
			
			//top100Languages.add(new Language(langName, totalStars, reposCount, reposOfCurrentLanguage));
			top100Languages.add(new Language(langName, totalStars, reposCount));

		});
		
		//sort languages by total earned stars in descending order
		top100Languages.sort(Comparator.comparing(Language::getStars,Comparator.reverseOrder()));
		
		//Add HATEOS
		for(int i=0; i< top100Languages.size(); i++) {
			
			top100Languages.get(i)
							.add(linkTo(LanguageServiceImpl.class).slash("trending/languages/"+(i+1)).withSelfRel())
							.add(linkTo(LanguageServiceImpl.class).slash("trending/languages/"+(i+1)+"/repositories").withRel("repositories"));
		}
			
		return top100Languages;
	}
	


	
	@Override
	//Get language of specified rank
	public Language getLanguageOfRank(int rankId, List<Item> top100Items) {
		
		//trending languages in descending order
		List<Language> trendingLanguages = getTrendingLanguagesFrom(top100Items);
		
		return trendingLanguages.get(rankId-1);
	}

	


}
