package com.goalkeeper.hcb.security.service;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.goalkeeper.hcb.security.model.HcbUserPrincipal;
import com.goalkeeper.hcb.security.model.User; 

@Service
@Qualifier(value = "hcbUserDetailService")
public class HcbUserDetailService implements UserDetailsService {
 
	    @Override  
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	            System.out.println("loadUserByUsername");
	    		//User user = userService.getUserByUsername(userName);
	    	    // just create a user here for testing so don't have to hook up repository
	    		User user = new User();
	    		user.setId("kimId");
	    		user.setPassword("password");
	    		// in our app, the mobile number is the username
	    		user.setMobileNumber("9788570613");// really we will load the user from the userService
	    	    if(user == null){
	    	     throw new UsernameNotFoundException("User not found with username : " + username);
	    	    }

	    	    return HcbUserPrincipal.create(user);
	     }

	    // This method is used by JWTAuthenticationFilter  
	    public UserDetails loadUserById(String id) {
            System.out.println("loadUserById");
	    	//User user = userService.getUserById(id);
    	    // just create a user here for testing so don't have to hook up repository
	    	User user = new User();
    		user.setId("kimId");
    		user.setPassword("password");
    		// in our app, the mobile number is the username
    		user.setMobileNumber("9788570613"); // really we will load the user from the userService
    	    if(user == null){
    	     throw new UsernameNotFoundException("User not found with id : " + id);
    	    }

    	    return HcbUserPrincipal.create(user);
	    }
	}
