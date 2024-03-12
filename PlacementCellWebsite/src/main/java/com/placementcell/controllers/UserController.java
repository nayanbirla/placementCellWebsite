package com.placementcell.controllers;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placementcell.dto.TokenResponse;
import com.placementcell.entities.Users;
import com.placementcell.request.LoginData;
import com.placementcell.services.JwtService;
import com.placementcell.services.UserInfoServices;
import com.placementcell.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserInfoServices userInfoServices;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/{email}")
	public ResponseEntity<Users> getDetails(@PathVariable String email){
		
		Users user=userService.getByEmail(email);
		user.setPassword("");
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Users> update(@RequestBody Users users)
	{
		return new ResponseEntity<Users>(userService.add(users),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public TokenResponse loginUser(@RequestBody LoginData loginusers)
	{
		try {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginusers.getEmail(),loginusers.getPassword()));
		if(authentication.isAuthenticated())
		{
			Users user=userService.getByEmail(loginusers.getEmail());
			TokenResponse token=new TokenResponse();
			token.setToken(jwtService.genetateToke(user.getEmail(),user.getRole()));
			token.setStatus(true);
			return token;
		}else {
			throw new UsernameNotFoundException("Invalid User Request");
		}
		}catch(Exception ee)
		{
			TokenResponse tokenfail=new TokenResponse();
			tokenfail.setToken("Failed to Login! Something went Wrong");
			tokenfail.setStatus(false);
			return tokenfail;
		}

	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Users users)
	{
		return new ResponseEntity<String>(userInfoServices.addUser(users),HttpStatus.OK);
	}
	
}
