package com.project.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springbootdemo.model.ExpenseTrackerModel;

public interface ExpenseTrackerRepository extends JpaRepository<ExpenseTrackerModel, Integer>{

}
