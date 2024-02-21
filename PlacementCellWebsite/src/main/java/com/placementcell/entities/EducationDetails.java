package com.placementcell.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="education_details")
public class EducationDetails {

	@Id
	@OneToOne
	@JsonBackReference
	private Users id;
	private double tenthPercentage;
	private double twelthPercentage;
	private double ug;
	private double pg;
	public EducationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EducationDetails(Users id, double tenthPercentage, double twelthPercentage, double ug, double pg) {
		super();
		this.id = id;
		this.tenthPercentage = tenthPercentage;
		this.twelthPercentage = twelthPercentage;
		this.ug = ug;
		this.pg = pg;
	}
	public Users getId() {
		return id;
	}
	public void setId(Users id) {
		this.id = id;
	}
	public double getTenthPercentage() {
		return tenthPercentage;
	}
	public void setTenthPercentage(double tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}
	public double getTwelthPercentage() {
		return twelthPercentage;
	}
	public void setTwelthPercentage(double twelthPercentage) {
		this.twelthPercentage = twelthPercentage;
	}
	public double getUg() {
		return ug;
	}
	public void setUg(double ug) {
		this.ug = ug;
	}
	public double getPg() {
		return pg;
	}
	public void setPg(double pg) {
		this.pg = pg;
	}	
}
