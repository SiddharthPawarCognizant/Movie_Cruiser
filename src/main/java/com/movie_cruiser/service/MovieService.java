package com.movie_cruiser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_cruiser.Method.Movie;
import com.movie_cruiser.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository MR;

	public List<Movie> GetAdminList() {
		return MR.findAll();
	}

	public List<Movie> GetCustomerList(String Active) {
		return MR.findByIsActive(Active);
	}

	@Transactional
	public void EditList(Movie movie) {
		MR.save(movie);
	}

	public Movie GetMovieRow(int MovieId) {
		return MR.findAllById(MovieId);
	}

	public Movie UpdateMovie(Movie movie) {
       MR.save(movie);
       return movie;
	}
}
