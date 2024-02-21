package com.placementcell.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placementcell.entities.Users;
import com.placementcell.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getDetails(@PathVariable int id){
		return new ResponseEntity<Users>(userService.get(id),HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Users> update(@RequestBody Users users)
	{
		return new ResponseEntity<Users>(userService.add(users),HttpStatus.OK);
	}
	
}
