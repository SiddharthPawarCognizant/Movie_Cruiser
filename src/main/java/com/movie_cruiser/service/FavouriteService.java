package com.movie_cruiser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_cruiser.Method.Favourite;
import com.movie_cruiser.repository.FavouriteRepository;

@Service
public class FavouriteService {
	
	@Autowired
	FavouriteRepository FR;
	
	@Transactional
	public void addToFavourites(Favourite fav) {
		FR.save(fav);
	}
	
	
	public List<Favourite> getallFav(int id){
		return FR.findByFavusid(id);
	}
	
	

	@Transactional
	public void deleteFromFav(int favid) {
		FR.deleteByFavmoid(favid);
	}
//	@Transactional
//	public List<Favourite> GetFavList(String name) {
//		return FR.ShowFav(name);
//	}

}
