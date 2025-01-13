package com.project.springbootdemo.controller;

import java.io.ByteArrayOutputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springbootdemo.model.ExpenseTrackerModel;
import com.project.springbootdemo.model.UserModel;
import com.project.springbootdemo.repository.UsersRepository;
import com.project.springbootdemo.service.ExpenseTrackerService;

@RestController
@RequestMapping("/expense")
@CrossOrigin(origins = "*")
public class ExpenseTrackerController {

	@Autowired
	ExpenseTrackerService expenseTrackerService;

	@Autowired
	UsersRepository usersRepository;

	@PostMapping(value = "/login")
	public ResponseEntity<Object> login(@RequestBody UserModel userRequest) {
		try {

			Optional<UserModel> existingUser = usersRepository.findByEmailId(userRequest.getEmailId());

			if (existingUser.isPresent()) {
				return ResponseEntity.ok().body(existingUser.get());

			} else {
				UserModel userModelResponse = usersRepository.save(userRequest);
				return ResponseEntity.ok().body(userModelResponse);
			}

		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data Integrity Violation: " + e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
		}
	}

	@PostMapping(value = "/addexpense")
	public ResponseEntity<Object> addExpense(@RequestBody ExpenseTrackerModel expense) {
		try {

			ExpenseTrackerModel expenseTrackerModelResponse = expenseTrackerService.addExpense(expense);

			return ResponseEntity.ok().body(expenseTrackerModelResponse);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data Integrity Violation: " + e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
		}
	}

	@GetMapping("/generatereport")
	public ResponseEntity<?> downloadReport() {
		try {

			ByteArrayOutputStream outputStream = expenseTrackerService.generateExcelReport();

			byte[] excelFile = outputStream.toByteArray();

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=expenses.xlsx");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM).body(excelFile);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data Integrity Violation: " + e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
		}
	}

}
