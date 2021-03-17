package com.movie_cruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie_cruiser.Method.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	public List<Movie> findByIsActive(String active);

	public Movie findAllById(int movieId);

//   @Query("insert into favourites fav_us_id=user_id and fav_mo_id=menu_id)
//	public void addToFavourites(@Param ("user_id")int user_id,@Param ("menu_id")int menu_id);

}
