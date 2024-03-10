package com.placementcell.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users_info")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    @Column(unique = true,nullable = false)
	private String email;
	private String password;
	private String role;
	@JsonManagedReference
	@OneToOne(mappedBy = "id")
	private UsersDetails usersDetails;
	@JsonManagedReference
	@OneToOne(mappedBy = "id")
	private EducationDetails educationDetails;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int id, String email, String password, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
}
