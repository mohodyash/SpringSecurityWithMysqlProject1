package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.principal.UserPrincipal;
import com.example.demo.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	     @Autowired
	     private UserRepository userRepository;
	      
		   @Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			 
			   // Database Repository
			   
			   System.err.println("user name from loadUserByUsername :: "+username);
			   User user = userRepository.findUserByUsername(username);
			   if(user == null)
			   {
				   throw new UsernameNotFoundException(" user 404");
			   }
			return new UserPrincipal(user);
}
}
