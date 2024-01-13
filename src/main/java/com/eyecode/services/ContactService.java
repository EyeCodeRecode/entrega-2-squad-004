package com.eyecode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyecode.entities.Contact;
import com.eyecode.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repository;
	
	public void saveContact(Contact contact) {
		
		repository.save(contact);
		
	}
	
}
