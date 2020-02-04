package com.saberhamza.restcontroller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saberhamza.entity.ItemCollections;
import com.saberhamza.service.ItemService;

/**
 * 
 * ItemServiceImp implements ItemService. Its where the business logic resides to get the top 100 repositories in github.
 * 
 * @author Hamza SABER
 */
@RestController
@RequestMapping("/trending")
public class TopReposController {
	
	/**
	 * 
	 * Dependency injection of ItemService interface.
	 */
	@Autowired
	ItemService itemService;
	
	/**
	 * 
	 * Collection that holds the top 100 repositories in github.
	 */
	private ItemCollections top100repos;
	

	/**
	 * 
	 * After this bean is constructed, we get the initial unordered top 100 repositories in github.
	 */
	@PostConstruct
	public void populate() {
		top100repos = new ItemCollections(itemService.loadTop100Repos());
	}
	
	/**
	 * 
	 * @return List of top 100 repositories in github.
	 */
	@GetMapping(value="/top100repos",produces = MediaTypes.HAL_JSON_VALUE)
	public ItemCollections getTrendingLanguages(){
		return top100repos;
	}

}