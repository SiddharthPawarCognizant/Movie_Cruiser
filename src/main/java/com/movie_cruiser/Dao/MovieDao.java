package com.movie_cruiser.Dao;

import java.util.List;

import com.movie_cruiser.Method.Favourite;
import com.movie_cruiser.Method.Movie;

public interface MovieDao {

	public List<Movie> MovieList();
	public List<Movie> MovieListCustomer();
	public List<Favourite> FavouriteItems(String name);

	
}
