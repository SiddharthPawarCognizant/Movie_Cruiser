package com.movie_cruiser.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.movie_cruiser.Method.Favourite;
@Component
public class FavouriteMapper implements RowMapper<Favourite> {

	@Override
	public Favourite mapRow(ResultSet rs, int rowNum) throws SQLException {
		Favourite Fav=new Favourite();
		Fav.setFavid(rs.getInt(1));
		Fav.setFavmoid(rs.getInt(2));
		Fav.setFavusid(rs.getInt(3));
//		Fav.setTitle(rs.getString(3));
//		Fav.setBox_Office(rs.getInt(4));
		
		return Fav;
		
	}

}
