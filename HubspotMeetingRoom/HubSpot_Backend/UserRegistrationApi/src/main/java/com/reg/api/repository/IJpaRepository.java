package com.reg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reg.api.model.RegisterUser;

@Repository
public interface IJpaRepository extends JpaRepository<RegisterUser, String> {

	@Query("SELECT u FROM RegisterUser u WHERE u.email=?1 AND u.password=?2")
	RegisterUser validateUser(String email,String password);
}
