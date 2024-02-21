package com.placementcell.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users_details")
public class UsersDetails {

	@Id
	@OneToOne
	@JsonBackReference
	private Users id;
	private String firstName;
	private String middleName;
	private String lastName;
	@Column(unique=true)
	private String personalEmail;
	private String gender;
	private String contact;
	private String course;
	private String image;
	
	public UsersDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsersDetails(Users id, String firstName, String middleName, String lastName, String personalEmail,
			String contact, String course, String image, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.personalEmail = personalEmail;
		this.contact = contact;
		this.course = course;
		this.image = image;
		this.gender = gender;
	}

	public Users getId() {
		return id;
	}
	public void setId(Users id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}	
	
}
