package com.movie_cruiser.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie_cruiser.Dao.MovieDaoImpl;
import com.movie_cruiser.Method.Favourite;
import com.movie_cruiser.Method.Movie;
import com.movie_cruiser.Method.User;
import com.movie_cruiser.service.FavouriteService;
import com.movie_cruiser.service.MovieService;
import com.movie_cruiser.service.UserService;

@Controller
public class MovieController {
	
	@Autowired
	MovieService movieservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	FavouriteService favouriteService;
	


	@Autowired
	MovieDaoImpl Dao;
	

	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public String MovieList(HttpServletRequest request, ModelMap model, @RequestParam String name,
			@RequestParam String password) {
		List<User> users = userservice.GetAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(name) && user.getPassword().equals(password)) {

				if (user.getRole().equals("Customer")) {
					List<Movie> listCust = movieservice.GetCustomerList("Yes");
					model.put("listCust", listCust);
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					return "Cust";
				} else if (user.getRole().equals("Admin")) {
					List<Movie> list = movieservice.GetAdminList();
					model.put("list", list);
					return "Ad";
				}
			}
		}
		model.put("errorMessage", "Invalid Credentials");
		return "login";
	}

	@RequestMapping(value = "/Signup", method = RequestMethod.GET)
	public String showSignUp(ModelMap model) {
		return "SignUp";
	}

	@RequestMapping(value = "/Signup", method = RequestMethod.POST)
	public String addUser(ModelMap model, @RequestParam String username, @RequestParam String password) {
//		Dao.addUser(username, password);
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("Customer");
		userservice.NewUser(user);
		return "login";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String AddToFavourites(ModelMap model, HttpServletRequest request, @RequestParam int menu_id) {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		Favourite fav=new Favourite();
		fav.setFavusid(user.getId());
		fav.setFavmoid(menu_id);
		favouriteService.addToFavourites(fav);
//		favouriteService.addToFavourites(user.getId(), menu_id);
		List<Movie> listCust = movieservice.GetCustomerList("Yes");
		model.put("listCust", listCust);
//		List<Movie> listCust = Dao.MovieListCustomer();
//		model.put("listCust", listCust);
		return "Cust";
	}
	
	@RequestMapping(value = "/car")
	public String showFavourites(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");

//		List<Favourite> cart = Dao.FavouriteItems(user.getUsername());
		List<Favourite> cart = favouriteService.getallFav(user.getId());
		List<Movie> movie=new ArrayList<>();
		for(Favourite c:cart) {
			Movie movies=movieservice.GetMovieRow(c.getFavmoid());
			movie.add(movies);
		}
		model.put("MovieRow",movie);
//		model.put("Cartlist", cart);
		return "Cart";
	}

	@RequestMapping(value = "/return")
	public String returnToMainPage(ModelMap model) {
		List<Movie> listCust = movieservice.GetCustomerList("Yes");
		model.put("listCust", listCust);
		return "Cust";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showEdit(ModelMap model, @RequestParam int menu_id) {
		return "Edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String viewEdit(ModelMap model, @RequestParam int menu_id,  @RequestParam String itemedit,@RequestParam String activity,
			@RequestParam String Category, @RequestParam String free, @RequestParam int price) {
		Movie movie = new Movie();
		movie.setTitle(itemedit);
		movie.setBoxOffice(price);
		movie.setIsActive(activity);
		movie.setGenre(Category);
		movie.setHasTeaser(free);
		movie.setId(menu_id);
//		Dao.EditMovieItem(movie);
		movieservice.EditList(movie);
		return "Edit";
	}  
	
	
	@RequestMapping(value = "/returnAdmin")
	public String ReturnToAdmin(ModelMap model) {
//		List<Movie> list = Dao.MovieList();
		List<Movie> list = movieservice.GetAdminList();
		model.put("list", list);
		return "Ad";
	}
     
	
	@RequestMapping(value = "/logout")
	public String ReturnToLogin() {
		return "redirect:login1";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String Delete(@RequestParam int id) {
//		Dao.DeleteFav(id);
		favouriteService.deleteFromFav(id);
		return "redirect:car";
	}
	
//	@CrossOrigin
//	@ResponseBody
//	@RequestMapping(value = "/Angular")
//	public List<Movie> Angular(ModelMap model) {
//		List<Movie> list = Dao.MovieList();
//		model.put("list", list);
//		return list;
//	}
	
	
	
	
  }
