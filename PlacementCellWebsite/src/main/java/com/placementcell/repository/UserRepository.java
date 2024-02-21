package com.placementcell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placementcell.entities.Users;
@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{

}
