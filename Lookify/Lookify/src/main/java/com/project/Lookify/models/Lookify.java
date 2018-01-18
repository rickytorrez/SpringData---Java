package com.project.Lookify.models;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Lookify{
	@Id
	@GeneratedValue
	private long id;

	//Validators
	@Size(min = 2, max = 20, message = "Title must be longer than two characters long.")
	private String title;

	@Size(min = 2, max = 20, message = "Artist must be longer than two characters long.")
	private String artist;
	
	@NotNull(message = "Rating must be a number")
	private int rating;
	
	
	
	public Lookify(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public Lookify(String title, String artist, int rating){
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getArtist(){
		return artist;
	}

	public void setArtist(String artist){
		this.artist = artist;
	}

	public int getRating(){
		return rating;
	}

	public void setRating(int rating){
		this.rating = rating;
	}



	// Member variables and annotations go here.
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	// Setters and Getters go here
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

	
}
