package com.eyecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eyecode.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
