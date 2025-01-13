package com.project.springbootdemo.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.project.springbootdemo.model.ExpenseTrackerModel;

@Service
public interface ExpenseTrackerService {

	public ExpenseTrackerModel addExpense(ExpenseTrackerModel expense);

	public ByteArrayOutputStream generateExcelReport();

}
