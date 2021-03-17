package com.movie_cruiser;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie_cruiser.Method.Movie;
import com.movie_cruiser.service.MovieService;

@SpringBootTest
class MovieCruiserApplicationTests {

	
	@Autowired
	MovieService MS;
	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void check() {
		List<Movie> list = MS.GetAdminList();
    System.out.println(list);
		
	}

}
