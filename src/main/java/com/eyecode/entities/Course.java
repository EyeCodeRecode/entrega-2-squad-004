package com.eyecode.entities;

import java.util.Base64;
import java.util.List;

import org.springframework.util.Base64Utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String CourseName;
	
	@Column
	private String Description;
	
	@Column
	private String type;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;

	public Course(String courseName, String description, String type , byte[] image) {
		this.CourseName = courseName;
		this.Description = description;
		this.type = type;
		this.image = image;
		
	}

	public Course( ) {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}
	
	public String getBase64() {
		return Base64Utils.encodeToString(image);
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
