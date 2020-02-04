package com.saberhamza.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saberhamza.entity.Item;
import com.saberhamza.entity.Language;
import com.saberhamza.entity.Repository;
import com.saberhamza.exception.RepositoryNotFoundException;

/**
 * 
 * RespositoryServiceImpl implements RespositoryService interface. Its where the business logic resides to get repositories of a trending language.
 * 
 * @author Hamza SABER
 *
 */
@Service
public class RespositoryServiceImpl implements RepositoryService {

	/**
	 * Dependency injection of LanguageService interface.
	 */
	@Autowired
	LanguageService languageService;

	/**
	 * 
	 * @param top100Items top 100 github repositories
	 * @param language trending language that we want to get its repositories
	 * @param languageRankId the language rank
	 * 
	 * @return List of repositories using current programming language
	 */
	@Override
	public List<Repository> getReposFrom(List<Item> top100Items,Language language, int languageRankId){
		
		List<Repository> repos = new ArrayList<>();
		
		//Filter the top 100 repos to get only thos using the language we want, and add them to "repos" list
		top100Items.stream()
				   .filter(i -> i.getLanguage().equals(language.getName()))
				   .forEach(item ->{
			
				   		repos.add(new Repository(item.getName(),item.getDescription(), item.getHtml_url()));
				   });
		
		//Add HATEOS links
		for(int i=0; i< repos.size(); i++) {
			
			repos.get(i)
					.add(linkTo(RespositoryServiceImpl.class).slash("trending/languages/"+languageRankId+"/repositories/"+(i+1)).withSelfRel())
					.add(linkTo(RespositoryServiceImpl.class).slash("trending/languages/"+languageRankId).withRel("language"));
		}
		
		return repos;
	}

	
	/**
	 * 
	 * @param rankId language's rank
	 * @param reposId the specified repository id
	 * @param top100Items top 100 github repositories
	 * 
	 * @return specified repository
	 */
	@Override
	public Repository getRepositoryOfLanguageWithRank(int rankId, int reposId, List<Item> top100Items) {
		
		//Get language of specified rank
		Language lang = languageService.getLanguageOfRank(rankId,top100Items);
		
		//Get repositories of specified language
		List<Repository> repos = getReposFrom(top100Items, lang,rankId);
		
		int repositoriesCount = repos.size();
		
		if(reposId<=0 || reposId >repositoriesCount) {
			throw new RepositoryNotFoundException("Repository not found - "+reposId);
		}
		
		
		return repos.get(reposId-1);
	}

}
