package com.saberhamza.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saberhamza.entity.Item;
import com.saberhamza.service.ItemService;

@RestController
@RequestMapping("/trending")
public class TopReposController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping(value="/top100repos",produces = MediaTypes.HAL_JSON_VALUE)
	public List<Item> getTrendingLanguages(){

		//Get top 100 repositories with a specified language
		return itemService.loadTop100Repos();
		
	}

}
