package com.placementcell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementcell.entities.EducationDetails;
import com.placementcell.entities.Users;
import com.placementcell.entities.UsersDetails;
import com.placementcell.exceptions.InvalidEmailException;
import com.placementcell.exceptions.UserNotFoundException;
import com.placementcell.repository.UserRepository;
import com.placementcell.request.UserRequestData;

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
	
	public Users getByEmail(String email) {
		return userRepository.FindByEmail(email).get();
	}
	
	
	public Users saveUserRequestData(UserRequestData userRequestData) throws UserNotFoundException,InvalidEmailException
	{
		Users existingUser=userRepository.findById(userRequestData.getId()).orElseThrow(()->new UserNotFoundException("User Not Found"));
		if(!(existingUser.getEmail().equals(userRequestData.getEmail())))
		{
			throw new InvalidEmailException("User Mail Not Found");
		}
	    UsersDetails userDetails=existingUser.getUsersDetails();
	    if(userDetails==null)
	    {
	    	userDetails=new UsersDetails();
	    }

 	    userDetails.setUsers(existingUser);
	    userDetails.setFirstName(userRequestData.getFirstName());
	    userDetails.setMiddleName(userRequestData.getMiddleName());
	    userDetails.setLastName(userRequestData.getLastName());
	    userDetails.setPersonalEmail(userRequestData.getPersonalEmail());
	    userDetails.setGender(userRequestData.getGender());
	    userDetails.setContact(userRequestData.getContact());
	    userDetails.setImage(userRequestData.getImage());
	    
	    existingUser.setUsersDetails(userDetails);
 
	    EducationDetails educationDetails=existingUser.getEducationDetails();
	    if(educationDetails==null)
	    {
	    	educationDetails=new EducationDetails();
	    }
	    educationDetails.setUsers(existingUser);
	    educationDetails.setTenthPercentage(userRequestData.getTenthPercentage());
	    educationDetails.setTwelthPercentage(userRequestData.getTwelthPercentage());
	    educationDetails.setUg(userRequestData.getUg());
	    educationDetails.setPg(userRequestData.getPg());
		
		existingUser.setEducationDetails(educationDetails);
//		System.out.println(existingUser);
//		System.out.println(existingUser.getUsersDetails());
		userRepository.save(existingUser);
		
		return existingUser;
	} 
}
