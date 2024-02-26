package com.placementcell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placementcell.entities.CompanyDetails;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails,Integer> {

}
