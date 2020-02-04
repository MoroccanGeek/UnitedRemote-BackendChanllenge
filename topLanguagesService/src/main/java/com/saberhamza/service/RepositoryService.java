package com.saberhamza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saberhamza.entity.Item;
import com.saberhamza.entity.Language;
import com.saberhamza.entity.Repository;

/**
 * 
 * @author Hamza SABER
 *
 */
@Service
public interface RepositoryService {
	
	/**
	 * 
	 * @param top100Items top 100 github repositories
	 * @param language trending language that we want to get its repositories
	 * @param languageRankId the language rank
	 * 
	 * @return List of repositories using current programming language
	 */
	List<Repository> getReposFrom(List<Item> top100Items,Language language, int languageRankId);
	
	/**
	 * 
	 * @param rankId language's rank
	 * @param reposId the specified repository id
	 * @param top100Items top 100 github repositories
	 * 
	 * @return specified repository
	 */
	Repository getRepositoryOfLanguageWithRank(int rankId, int reposId, List<Item> top100Items);

}
