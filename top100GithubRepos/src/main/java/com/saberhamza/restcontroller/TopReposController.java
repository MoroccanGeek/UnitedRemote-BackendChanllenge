package com.saberhamza.restcontroller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saberhamza.entity.ItemCollections;
import com.saberhamza.service.ItemService;

@RestController
@RequestMapping("/trending")
public class TopReposController {
	
	@Autowired
	ItemService itemService;
	
	private ItemCollections top100repos;
	
	@PostConstruct
	public void populate() {
		
		top100repos = new ItemCollections(itemService.loadTop100Repos());
	}
	
	@GetMapping(value="/top100repos",produces = MediaTypes.HAL_JSON_VALUE)
	public ItemCollections getTrendingLanguages(){

		return top100repos;
		
	}

}
