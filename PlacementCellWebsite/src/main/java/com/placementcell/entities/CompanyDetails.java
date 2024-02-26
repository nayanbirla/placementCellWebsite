package com.placementcell.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CompanyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	@Column(unique = true)
    private String companyName;
    @Column(length = 1000)
    private String description;
    private boolean hiringStatus;
    @OneToMany(mappedBy = "companyDetailsPlaced")
    @JsonManagedReference
    private List<PlacedStudent> placedStudent;
    
    @OneToMany(mappedBy = "companyDetails")
    @JsonManagedReference
    private List<Questions> questions;
    
	public CompanyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyDetails(int companyId, String companyName, String description, boolean hiringStatus) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.description = description;
		this.hiringStatus = hiringStatus;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isHiringStatus() {
		return hiringStatus;
	}
	public void setHiringStatus(boolean hiringStatus) {
		this.hiringStatus = hiringStatus;
	}
    
    
}
