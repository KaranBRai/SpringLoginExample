package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.model.User;
import com.example.login.service.UserService;

@RestController
@RequestMapping("/")
public class BaseController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String hello() {
		
		return "This is home page";
	}
	
	
	@GetMapping("/save-user")
	public String saveUser(@RequestParam("username") String username, @RequestParam("name") String name, 
			@RequestParam("age") int age, @RequestParam("password") String password){
		
		User user = new User(username,name,age,password);
		
		userService.saveMyUser(user);
		
		return "User is saved";
	}

}


// controller > service > repository > user ....data save flow

// @RequestParam will ask the input from user

