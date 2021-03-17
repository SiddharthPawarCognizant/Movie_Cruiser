package com.movie_cruiser.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movie_cruiser.Method.Movie;
import com.movie_cruiser.Method.User;
import com.movie_cruiser.repository.MovieRepository;
import com.movie_cruiser.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository US;
	
	@Autowired
	MovieRepository MR;
	
	public List<User> GetAllUsers() {
		return US.findAll();
	}

    public void NewUser(User user){
    	 US.save(user);
    }
      
    public User getbyuser(String user){
   	return US.findByUsername(user);
   }
    
	public Movie removeFavorites(String name, int id) {
		User user = US.findByUsername(name);
		
		if(user == null) {
			throw new UsernameNotFoundException("ERROR");
		}
		
		Set<Movie> favorites = user.getFavourites();
		Movie movie = MR.findById(id).get();
		favorites.remove(movie);
		user.setFavourites(favorites);
		US.save(user);
		
		return movie;
	}
	
	
	public Movie addToFavorites(String username, Movie movie) {

		User user = US.findByUsername(username);
		Set<Movie> favorites = user.getFavourites();
		favorites.add(movie);
		user.setFavourites(favorites);
		US.save(user);
		
		return movie;

	}
	
}
