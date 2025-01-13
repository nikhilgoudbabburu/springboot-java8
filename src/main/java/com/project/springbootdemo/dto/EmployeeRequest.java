package com.project.springbootdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeRequest {
	
	@NotEmpty(message = "Name cannot be empty")
	@NotNull(message = "Name is Mandatory")
	private String firstName;
	private String lastName;
	
	@Email(message = "Invalid email address")
	private String emialId;
}
