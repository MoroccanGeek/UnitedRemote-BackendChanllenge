package com.saberhamza.restcontroller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.saberhamza.entity.ItemCollections;
import com.saberhamza.entity.Language;
import com.saberhamza.entity.LanguageCollections;
import com.saberhamza.entity.Repository;
import com.saberhamza.entity.RepositoryCollections;
import com.saberhamza.exception.RankNotFoundException;
import com.saberhamza.service.LanguageService;
import com.saberhamza.service.RepositoryService;

/**
 * Controller class to get trending languages.
 * 
 * @author Hamza SABER
 *
 */
@RestController
@RequestMapping("/trending")
public class LanguagesRestController {
	
	/**
	 * Dependency injection for RestTemplate.
	 */
	@Autowired
	RestTemplate restTemplate;

	/**
	 * Dependency injection for LanguageService interface.
	 */
	@Autowired
	LanguageService languageService;
	
	/**
	 * Dependency injection for RepositoryService interface.
	 */
	@Autowired
	RepositoryService repositoryService;
	
	/**
	 * Holder for top 100 github repositories by earned stars in descendant order.
	 */
	private ItemCollections githubTop100Repos;
	
	/**
	 * After Bean is initialized, we get top 100 repositories which have a non NULL language
	 */
	@PostConstruct
	private void getGithubTop100Repos() {
		githubTop100Repos = restTemplate.getForObject("http://localhost:8079/repos/trending/top100repos", ItemCollections.class);
	}
	
	/**
	 * 
	 * @return top languages used in the top 100 Items
	 */
	@GetMapping(value="/languages",produces = MediaTypes.HAL_JSON_VALUE)
	public LanguageCollections getTrendingLanguages(){
		
		//Return top languages used in the top 100 Items
		List<Language> trendingLanguages = languageService.getTrendingLanguagesFrom(githubTop100Repos.getItems());
		
		return new LanguageCollections(trendingLanguages.size(),trendingLanguages);
	}
	
	/**
	 * Get language of rank {rankId}
	 * 
	 * @param rankId rank of language we want to get
	 * @return language of specified rank
	 */
	@GetMapping(value="/languages/{rankId}",produces = MediaTypes.HAL_JSON_VALUE)
	public Language getTrendingLanguageOfRank(@PathVariable int rankId){

		//Total number of languages in top 100 repositories.
		int trendingLanguagesCount = languageService.getTrendingLanguagesFrom(githubTop100Repos.getItems()).size();
		
		if(rankId<=0 || rankId >trendingLanguagesCount) {
			throw new RankNotFoundException("Rank not found - "+rankId);
		}

		//Return language of specified rank
		return languageService.getLanguageOfRank(rankId,githubTop100Repos.getItems());
	}
	
	/**
	 * 
	 * @param rankId rank of language we want to get its repositories
	 * @return Repositories of language with rank {rankId}
	 */
	@GetMapping(value="/languages/{rankId}/repositories",produces = MediaTypes.HAL_JSON_VALUE)
	public RepositoryCollections getRepositoriesOfLanguageWithRank(@PathVariable int rankId){

		int trendingLanguagesCount = languageService.getTrendingLanguagesFrom(githubTop100Repos.getItems()).size();
		
		if(rankId<=0 || rankId >trendingLanguagesCount) {
			throw new RankNotFoundException("Rank not found - "+rankId);
		}

		//Get language of specified rank
		Language lang = languageService.getLanguageOfRank(rankId,githubTop100Repos.getItems());
		
		//Get the language repositories
		List<Repository> repositories = repositoryService.getReposFrom(githubTop100Repos.getItems(), lang, rankId);
		
		return new RepositoryCollections(repositories.size(), repositories);
	}
	
	/**
	 * 
	 * @param rankId rank of language we want to get its repositories
	 * @param reposId specified repository to get
	 * @return Specified repository of language with rank {rankId}
	 */
	@GetMapping(value="/languages/{rankId}/repositories/{reposId}",produces = MediaTypes.HAL_JSON_VALUE)
	public Repository getRepositoryOfLanguageWithRank(@PathVariable int rankId, @PathVariable int reposId){

		// Total number of repositories of language with rank {rankId}
		int trendingLanguagesCount = languageService.getTrendingLanguagesFrom(githubTop100Repos.getItems()).size();
		
		if(rankId<=0 || rankId >trendingLanguagesCount) {
			throw new RankNotFoundException("Rank not found - "+rankId);
		}

		return repositoryService.getRepositoryOfLanguageWithRank(rankId, reposId, githubTop100Repos.getItems());
	}
		
}