package com.mfpe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mfpe.model.ProjectManagerDetails;


@Service
public class MyUserDetailsService implements UserDetailsService{
	

	@Autowired
	private ProjectManagerService projectManagerService;
	
	// this method returns the User object based on the username...
	// whose password will get checked with the password we provided in this User object..
	// if match --> authenticated , if not match --> user not authenticated
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Asking for the user-deatils in the User object");
		ProjectManagerDetails p = new ProjectManagerDetails(projectManagerService.getProjectManagerByUserName(username));
		return p;
	}
	
}
