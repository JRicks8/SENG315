package com.example.Storefront.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Storefront.domain.ItemRepository;
import com.example.Storefront.domain.Item;

@RestController
@RequestMapping("webapi/items")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping
	public Iterable<Item> getItems() {
		return itemRepository.findAll();
	}
	
	@GetMapping(path="{id}")
	public Optional<Item> getItem(@PathVariable Long id) {
		return itemRepository.findById(id);
	}
	
	@PostMapping
	public Item createItem(@RequestBody Item itemDetails) {
		return itemRepository.save(itemDetails);
	}
	
	@PutMapping(path="{id}")
	public Item updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
		return itemRepository.save(itemDetails);
	}
	
	@DeleteMapping(path="{id}")
	public void deleteItem(@PathVariable Long id) {
		itemRepository.deleteById(id);
	}
	
}