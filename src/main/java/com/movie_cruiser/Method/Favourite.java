package com.movie_cruiser.Method;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="favourites")
public class Favourite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fav_id")
	private int favid;
	
	@Column(name = "fav_mo_id")
	private int favmoid;
	

	@Column(name = "fav_us_id")
	private int favusid;
	
//	private String title;
//	private int box_Office;
	public int getFavmoid() {
		return favmoid;
	}
	public void setFavmoid(int favmoid) {
		this.favmoid = favmoid;
	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public double getBox_Office() {
//		return box_Office;
//	}
//	public void setBox_Office(int box_Office) {
//		this.box_Office = box_Office;
//	}
	
	public int getFavid() {
		return favid;
	}
	public void setFavid(int favid) {
		this.favid = favid;
	}
	
//	public Favourite(int fav_id, int fav_mo_id, String title, int box_Office) {
//		super();
//		this.fav_id = fav_id;
//		this.fav_mo_id = fav_mo_id;
//		this.title = title;
//		this.box_Office = box_Office;
//	}
//	
	public Favourite() {
		
	}
	public int getFavusid() {
		return favusid;
	}
	public void setFavusid(int favusid) {
		this.favusid = favusid;
	}
	
	
	
	
	
	
}
