package com.movie_cruiser.Method;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Box_Office")
	private int boxOffice;
	
	@Column(name = "Is_Active")
	private String isActive;
	
	@Column(name = "Date_Of_Launch")
	private Date  date_of_launch;
	
	@Column(name = "Genre")
	private String genre;
	
	@Column(name = "Has_Teaser")
	private String hasTeaser;


	
	
	public int getBoxOffice() {
		return boxOffice;
	}
	public void setBoxOffice(int boxOffice) {
		this.boxOffice = boxOffice;
	}
	public Date getDate_of_launch() {
		return date_of_launch;
	}
	public void setDate_of_launch(Date date_of_launch) {
		this.date_of_launch = date_of_launch;
	}
	public String getHasTeaser() {
		return hasTeaser;
	}
	public void setHasTeaser(String hasTeaser) {
		this.hasTeaser = hasTeaser;
	}
	
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
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	@ManyToMany(mappedBy="favourites")
	Set<User> userList;
	
	public Set<User> getUserList() {
		return userList;
	}
	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}
	
	
	public Movie() {
		
	}
	
	public Movie(int id, String title, int boxOffice, String isActive, Date date_of_launch, String genre,
			String hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.isActive = isActive;
		this.date_of_launch = date_of_launch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
		
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", Title=" + title + ", IsActive=" + isActive + ", Genre=" + genre + "]";
	}
}
