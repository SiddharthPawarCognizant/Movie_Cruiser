package com.movie_cruiser.Dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.movie_cruiser.Method.Movie;

@Component 
public class MovieMapper implements RowMapper<Movie> {
	

	@Override
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movie movie=new Movie();
		movie.setId(rs.getInt(1));
		movie.setTitle(rs.getString(2));
		movie.setBoxOffice(rs.getInt(3));
		movie.setIsActive(rs.getString(4));
		movie.setDate_of_launch(rs.getDate(5));
		movie.setGenre(rs.getString(6));
		movie.setHasTeaser(rs.getString(7));

		
		
		return movie;
	}

}
