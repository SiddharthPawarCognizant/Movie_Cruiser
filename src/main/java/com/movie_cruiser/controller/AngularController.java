package com.movie_cruiser.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie_cruiser.Dao.MovieDaoImpl;
import com.movie_cruiser.Method.Favourite;
import com.movie_cruiser.Method.Movie;
import com.movie_cruiser.Method.User;
import com.movie_cruiser.service.FavouriteService;
import com.movie_cruiser.service.MovieService;
import com.movie_cruiser.service.UserService;

@RestController
@CrossOrigin
public class AngularController {
	

	@Autowired
	MovieService movieservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	FavouriteService favouriteService;
	
	
	@Autowired
	MovieDaoImpl Dao;
	
	@RequestMapping("/welcome")
    public String welcome() {
        String text = "this is private page ";
        text+= "this page is not allowed to unauthenticated users";
        return text;
    }
	
	@RequestMapping(value = "/AdminList")
	public List<Movie> AdminList(ModelMap model) {
		List<Movie> list = Dao.MovieList();
		model.put("list", list);
		return list;
	}
	
	@RequestMapping(value = "/CustList")
	public List<Movie> CustomerList(ModelMap model) {
		List<Movie> listCust = movieservice.GetCustomerList("Yes");
		model.put("listCust", listCust);
		return listCust;
	}
	
	
	@RequestMapping(value = "/editget/{id}")
	public ResponseEntity<Movie> EditMovieGet(@PathVariable int id) {
		Movie movie=movieservice.GetMovieRow(id);
		return ResponseEntity.ok(movie);
	}
	
	@PutMapping(value = "/edit/{id}")
	public ResponseEntity<Movie> EditMovie(@PathVariable int id,@RequestBody Movie movie) {
		Movie movie1=movieservice.GetMovieRow(id);
		movie1.setTitle(movie.getTitle());
		movie1.setBoxOffice(movie.getBoxOffice());
		movie1.setDate_of_launch(movie.getDate_of_launch());
		movie1.setGenre(movie.getGenre());
		movie1.setHasTeaser(movie.getHasTeaser());
		Movie result=movieservice.UpdateMovie(movie1);
		return new ResponseEntity<Movie>(result,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/view-fav/{username}")
	public List<Movie> getfavlist(@PathVariable String username) {
		User user=userservice.getbyuser(username);
		List<Favourite> cart =favouriteService.getallFav(user.getId());
		List<Movie> movies=new ArrayList<Movie>(); 
		 for(Favourite f: cart) {
			Movie m= movieservice.GetMovieRow(f.getFavmoid());
			 movies.add(m);
		 }
		return movies;
	}
	
//	@RequestMapping(value = "/view-fav/{username}")
//	public List<Movie> viewFav (@PathVariable String username) {
//		User user=userservice.getbyuser(username);
//		Set<Movie> movies = user.getFavourites();
//		List<Movie> favoriteList = new ArrayList<Movie>();
//		for(Movie m : movies) {
//			favoriteList.add(m);
//		}
//		return favoriteList;
//	}
	
	
	
	
	@DeleteMapping(value = "/delete/{username}/{id}")
	public ResponseEntity<Movie> deleteFromFavorites(@PathVariable String username, @PathVariable int id){
		Movie movie = userservice.removeFavorites(username, id);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/add-to-favorites/{username}")
	public ResponseEntity<Movie> addToFavorites(@PathVariable String username, @RequestBody String id){		
		Movie movie = movieservice.GetMovieRow(Integer.parseInt(id));
		userservice.addToFavorites(username, movie);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
		
	}

}
