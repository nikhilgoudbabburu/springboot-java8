package com.project.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springbootdemo.model.EmployeeModel;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {

	
	List<EmployeeModel> findByEmail_id(String email_id);
	
	
	
}
 