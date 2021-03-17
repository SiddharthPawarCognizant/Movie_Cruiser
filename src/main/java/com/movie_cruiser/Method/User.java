package com.movie_cruiser.Method;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;



@Entity
@Table(name="users")
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "user_password")
	private String password;
	
	@Column(name = "user_role")
	private String role;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public User(int id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public User(String username) {
		super();
		this.username = username;
	}
	
	public User() {
		
	}
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="favourites",joinColumns= @JoinColumn(name="fav_us_id",referencedColumnName="user_id")
	,inverseJoinColumns=@JoinColumn(name="fav_mo_id",referencedColumnName="Id"))
	private Set<Movie> favourites;



	public Set<Movie> getFavourites() {
		return favourites;
	}
	public void setFavourites(Set<Movie> favourites) {
		this.favourites = favourites;
	}

}
