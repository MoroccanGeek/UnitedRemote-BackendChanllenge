package com.saberhamza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saberhamza.entity.Item;
import com.saberhamza.entity.Language;
import com.saberhamza.entity.Repository;

@Service
public interface RepositoryService {
	
	//List of repositories using current programming language
	List<Repository> getReposFrom(List<Item> top100Items,Language language, int languageRankId);
	
	Repository getRepositoryOfLanguageWithRank(int rankId, int reposId, List<Item> top100Items);

}
