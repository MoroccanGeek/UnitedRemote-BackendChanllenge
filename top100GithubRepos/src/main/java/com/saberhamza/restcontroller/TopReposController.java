package com.saberhamza.restcontroller;

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
	
	@GetMapping(value="/top100repos",produces = MediaTypes.HAL_JSON_VALUE)
	public ItemCollections getTrendingLanguages(){

		return new ItemCollections(itemService.loadTop100Repos());
		
	}

}
