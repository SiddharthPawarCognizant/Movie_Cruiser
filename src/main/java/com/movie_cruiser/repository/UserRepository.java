package com.movie_cruiser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie_cruiser.Method.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
        
	
	public User findByUsername(String name);


}
