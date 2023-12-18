package com.ajay.registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ajay.registration.entity.User;
import com.ajay.registration.repository.UserRepository;


@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
	
	@Autowired
    private UserRepository repo;
	
	@PostMapping("save")         //http://localhost:8080/user/save
	public String getuser(@RequestBody User user) {
	    User returnValue = new User();
	    returnValue.setName(user.getName());
	    returnValue.setUsername(user.getUsername());
	    returnValue.setEmail(user.getEmail());
	    returnValue.setPhone(user.getPhone());
	    returnValue.setPassword(user.getPassword());
	    returnValue.setGender(user.getGender());

	    repo.save(returnValue);

	    return "registration successful";
	}
	
	
	//LOGIN REQUEST
	
	 @PostMapping("login")
	    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
	        String username = loginRequest.getUsername();
	        String password = loginRequest.getPassword();

	        User user = repo.findByUsernameAndPassword(username, password);

	        if (user != null) {
	            // Return user details upon successful login
	            return ResponseEntity.ok(user); 
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed. Invalid username or password");
	        }
	    }
	
	

}
