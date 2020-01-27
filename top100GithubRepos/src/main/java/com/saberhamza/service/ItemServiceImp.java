package com.saberhamza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saberhamza.entity.GithubQuery;
import com.saberhamza.entity.Item;

@Service
public class ItemServiceImp implements ItemService {

	//Customizable github link to get JSON response of top 100 repositories sorted with earned stars in a descending order
	public String githubSearchApiLink(int theStars,int thePage) {
		
		return "https://api.github.com/search/repositories?q=stars:>="+thePage+"&sort=stars&order=desc&page="+thePage+"&per_page=100";
		
	}
	
	//Get top 100 repositories where language is NOT null
	@Override
	public List<Item> loadTop100Repos(){
		
		RestTemplate restTemplate = new RestTemplate();

		//Create new List of Items where their language is NOT null
		List<Item> tempItems = new ArrayList<>();
		
		//page number we begin with
		int pageNumber = 1;
		
		//While the new list items size not >=100
		while(tempItems.size()<100) {
			
			//Get github link with specified pageNumber
			String fooResourceUrl = githubSearchApiLink(500,pageNumber);
			
			//get the first 100 repositories; their languages can be null or NOT null
			GithubQuery response = restTemplate.getForObject(fooResourceUrl, GithubQuery.class);
			
			//filter the 100 repositories to get only those with a not null language and add them to the list
			tempItems.addAll(response.getItems().stream()
											.filter(e-> e.getLanguage()!=null)
											.collect(Collectors.toList()));
			
			pageNumber++;
			
		}
		
		//return the first 100 repositories
		return tempItems.stream()
							.limit(100)
							.collect(Collectors.toList());
	}

	
}