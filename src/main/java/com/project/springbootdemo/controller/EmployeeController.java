package com.project.springbootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.springbootdemo.dto.EmployeeRequest;
import com.project.springbootdemo.model.ApiResponse;
import com.project.springbootdemo.model.EmployeeModel;
import com.project.springbootdemo.repository.EmployeeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/getempname/{id}")
	public ResponseEntity<ApiResponse<String>> getEmpName(@PathVariable int id) {
		Optional<EmployeeModel> empModel = employeeRepository.findById(id);

		return empModel
				.map(e -> ResponseEntity.ok(new ApiResponse<>("Success", "Employee Name Found", e.getFirst_name()))) // Corrected
																														// line
				.orElse(ResponseEntity.status(404)
						.body(new ApiResponse<>("Failure", "Employee data not found for the id: " + id, "")));
	}

	@GetMapping("/getallempdata")
	public ResponseEntity<ApiResponse<List<EmployeeModel>>> getAllEmpData() {
		List<EmployeeModel> empModel = employeeRepository.findAll();
		if (empModel.isEmpty()) {
			return ResponseEntity.status(404)
					.body(new ApiResponse<>("Failure", "Employee data not found for the id: ", null));
		} else {
			return ResponseEntity.ok(new ApiResponse<>("Success", "Employee Details", empModel));

		}

	}

	@PostMapping("/saveemp")
	public ResponseEntity<ApiResponse<String>> saveEmployeeData(@Valid @RequestBody EmployeeRequest empRequest) {

		EmployeeModel empModel = new EmployeeModel();
		empModel.setFirst_name(empRequest.getFirstName());
		empModel.setLast_name(empRequest.getLastName());
		empModel.setEmail_id(empRequest.getEmialId());
		EmployeeModel dbResponse = employeeRepository.save(empModel);

		return ResponseEntity.ok(new ApiResponse<>("Success", "Employee Name : ", Integer.toString(dbResponse.getEmp_id()))); // Corrected
																												// line

	}

	@GetMapping("/getempnamereqpar")
	public String getEmpNameUsingReqParam(@RequestParam("id") int ids) {
		return "Nikhil";
	}

	@GetMapping("/getempnameoptional")
	public String getEmpNameOptiional(@RequestParam(required = false, defaultValue = "123") int id) {
		if (id == 1) {
			return "nikhil";
		}
		return "nikhil,pavan, akhil";
	}

	@GetMapping("/getempnamemulparam")
	public String getEmpNameMulParam(@RequestParam("id") int id, @RequestParam("name") String name) {
		return id + " : " + name;
	}

	@GetMapping("/getempnamereqpar2")
	public String getEmpNameUsingReqParam2(@RequestParam("id") int ids) {
		return "Nikhil";
	}
}
