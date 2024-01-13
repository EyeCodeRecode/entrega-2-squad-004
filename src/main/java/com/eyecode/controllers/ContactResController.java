package com.eyecode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyecode.entities.Contact;
import com.eyecode.services.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactResController {

	
	@Autowired
	ContactService service;
	
	@PostMapping("/")
	public void getMessageContact(@RequestBody Contact contact) {
		System.out.print(
				"name: " + contact.getName() +"\n"+
				"email: " + contact.getEmail() +"\n"+
				"phone: " + contact.getPhone() +"\n"+
				"message: " + contact.getMessage() 
				);
		
		service.saveContact(contact);
		
	}
	
	
	
}
