package rest.MariaDBExample.dao;

import java.util.List;

import rest.MariaDBExample.model.Contact;

public interface ContactsDAO {
	
	//CRUD Operations
	public String addContact(Contact contact);
	
	public Contact findByID(Long id);
	
	public String updateContact(Contact contact);
	
	public void deleteContact(Long id);
	 
	// QUERIES
	public List<Contact> findAll();

}
