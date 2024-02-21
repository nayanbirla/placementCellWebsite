package com.placementcell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementcell.entities.Users;
import com.placementcell.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<Users> getAll(){
		return userRepository.findAll();
	}
	
	public Users add(Users users) {
		return userRepository.save(users);
	}
	
	public List<Users> addAll(List<Users> users) {
		return userRepository.saveAll(users);
	}
	
	public Users get(int id) {
		return userRepository.findById(id).orElseThrow();
	}
	
}
