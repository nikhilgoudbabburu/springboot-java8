package com.project.springbootdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springbootdemo.model.UserModel;

public interface UsersRepository extends JpaRepository<UserModel, Integer>{
	
    Optional<UserModel> findByEmailId(String emailId);

}
