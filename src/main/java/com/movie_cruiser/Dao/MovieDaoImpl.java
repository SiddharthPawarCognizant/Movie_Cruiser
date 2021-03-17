package com.movie_cruiser.Dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.movie_cruiser.Method.Favourite;
import com.movie_cruiser.Method.Movie;
import com.movie_cruiser.Method.User;


@Service
public class MovieDaoImpl implements MovieDao{
	@Autowired
	MovieMapper map;
	@Autowired
	UserMapper umap;
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	FavouriteMapper Cmap;
	
	
	@Override
	public List<Movie> MovieList() {
		String sql="select* from movies";
		List<Movie> list=jdbc.query(sql, map);
		
		return list;
	}
	@Override
	public List<Movie> MovieListCustomer() {
		String sql="select * from movies where IsActive='Yes'";
		List<Movie> listCust=jdbc.query(sql, map);

		return listCust;
	}
	
	public void addUser(String uname, String pass) {
		String sql="Insert into users(user_name, user_password, user_role) values(?,?,?)";
		jdbc.update(sql, uname, pass,"Customer");
		
	}
	
	
	public List<User> getUser() {
		String sql="select * from users"; 
	  List<User> users=jdbc.query(sql,umap);
	  return users;
	  }
	
	public void addToFavourites(int user_id,int menu_id) {
		String sql="insert into favourites(fav_us_id,fav_mo_id) values(?,?)";
		jdbc.update(sql, user_id, menu_id);
		
	}
	
	@Override
	public List<Favourite> FavouriteItems(String name) {
		String sql="select f.fav_id,f.fav_mo_id,m.Title,m.Box_Office from movies m join favourites f on m.Id=f.fav_mo_id join users u on f.fav_us_id=u.user_id where u.user_name=?"; 
//		String sql="select fav_id,fav_mo_id,fav_us_id where fav_us_id=?"; 
		List<Favourite> cart=jdbc.query(sql,Cmap,name);
		  return cart;
	}
	
	public void EditMovieItem(Movie movie) {
		int BoxOffice=movie.getBoxOffice();
		String active=movie.getIsActive();
		String genre=movie.getGenre();
		String HasTeaser=movie.getHasTeaser();
		int id=movie.getId();
		String sql="update movies set Box_Office=?,IsActive=?,Genre=?,Has_Teaser=? where Id=?";
		jdbc.update(sql, BoxOffice, active,genre,HasTeaser,id);
		
	}
	
	public void DeleteFav(int id) {
		String sql="DELETE FROM favourites WHERE fav_id=?";
		jdbc.update(sql, id);
		
	}
	

}
