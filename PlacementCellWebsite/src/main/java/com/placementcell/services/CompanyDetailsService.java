package com.placementcell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementcell.entities.CompanyDetails;
import com.placementcell.repository.CompanyDetailsRepository;

@Service
public class CompanyDetailsService {

	@Autowired
	private CompanyDetailsRepository companyDetailsRepository;
	
	public CompanyDetails add(CompanyDetails companyDetails)
	{
		return companyDetailsRepository.save(companyDetails);
	}
	
	public List<CompanyDetails> getAll() {
		return companyDetailsRepository.findAll();
	}
	
	public CompanyDetails get(int id) {
		return companyDetailsRepository.findById(id).orElseThrow();
	}
}
