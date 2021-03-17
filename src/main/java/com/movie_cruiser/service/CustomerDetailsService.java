package com.movie_cruiser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movie_cruiser.Config.CustomUserDetails;
import com.movie_cruiser.Method.User;
import com.movie_cruiser.repository.UserRepository;


@Service
public class CustomerDetailsService implements UserDetailsService{

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if(username.equals("siddharth")) {
//			return new User("siddharth","phd", new ArrayList<>());
//		}else {
//			throw new UsernameNotFoundException("User not Found!!");
//		}
//		
//	}
	
	
	

	@Autowired
	UserRepository userRepository;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByUsername(username);
//		if(user == null) {
//			
//			throw new UsernameNotFoundException(username);
//			
//		}
//		AppUser appUser = new AppUser(user);
//		return appUser;
//	}
	
	
	 @Override
	    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

	        final User user = this.userRepository.findByUsername(userName);

	        if (user == null) {
	            throw new UsernameNotFoundException("User not found !!");
	        } else {
	            return new CustomUserDetails(user);
	        }

}
}