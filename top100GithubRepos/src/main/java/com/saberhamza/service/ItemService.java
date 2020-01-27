package com.saberhamza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saberhamza.entity.Item;

@Service
public interface ItemService {
	
	//Get top 100 repositories where language is NOT null
	public List<Item> loadTop100Repos();

}
