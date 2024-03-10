package com.placementcell.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placementcell.entities.CompanyDetails;
import com.placementcell.services.CompanyDetailsService;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyDetailsService companyDetailsService;
	
	@GetMapping
	public ResponseEntity<List<CompanyDetails>> getAll(){
		return new ResponseEntity<List<CompanyDetails>>(companyDetailsService.getAll(),HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDetails> get(@PathVariable int id){
		return new ResponseEntity<CompanyDetails>(companyDetailsService.get(id),HttpStatus.OK);
	}
}
