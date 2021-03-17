package com.movie_cruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie_cruiser.Method.Favourite;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {

	public List<Favourite> findByFavusid(int id);

//	public void deleteByFavid(int favid);

	public void deleteByFavmoid(int favid);
	 




//	public List<Favourite> findByFav_id(String name);

}
