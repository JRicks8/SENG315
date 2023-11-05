package com.example.SpringJPA.web;

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

import com.example.SpringJPA.domain.ContactRepository;
import com.example.SpringJPA.domain.Contact;

@RestController
@RequestMapping("webapi/contacts")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping
	public Iterable<Contact> getContacts() {
		return contactRepository.findAll();
	}
	
	@GetMapping(path="{id}")
	public Optional<Contact> getContact(@PathVariable Long id) {
		return contactRepository.findById(id);
	}
	
	@PostMapping
	public Contact createContact(@RequestBody Contact contactDetails) {
		return contactRepository.save(contactDetails);
	}
	
	@PutMapping(path="{id}")
	public Contact updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
		return contactRepository.save(contactDetails);
	}
	
	@DeleteMapping(path="{id}")
	public void deleteContact(@PathVariable Long id) {
		contactRepository.deleteById(id);
	}
	
}