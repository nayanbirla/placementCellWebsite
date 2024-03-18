package com.placementcell.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Announcement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private LocalDate datePosted;
	private LocalDate dateToRemove; // Date to remove the announcement

	// Constructor
	public Announcement(int id, String title, String content, LocalDate datePosted, LocalDate dateToRemove) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.datePosted = datePosted;
		this.dateToRemove = dateToRemove;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(LocalDate datePosted) {
		this.datePosted = datePosted;
	}

	public LocalDate getDateToRemove() {
		return dateToRemove;
	}

	public void setDateToRemove(LocalDate dateToRemove) {
		this.dateToRemove = dateToRemove;
	}

	// toString() method to represent Announcement as a string
	@Override
	public String toString() {
		return "Announcement{" + "id=" + id + ", title='" + title + '\'' + ", content='" + content + '\''
				+ ", datePosted=" + datePosted + ", dateToRemove=" + dateToRemove + '}';
	}
}
