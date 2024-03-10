package com.placementcell.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.placementcell.entities.Users;
@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{
   
	@Query(value="select * from users_info where email =:email ",nativeQuery=true)
	Optional<Users> FindByEmail(@Param("email") String email);
}
