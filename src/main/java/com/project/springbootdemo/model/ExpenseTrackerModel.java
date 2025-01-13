package com.project.springbootdemo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="expensetracker")
public class ExpenseTrackerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exp_id")
	private int expId;
	
	@Column(name = "exp_date", nullable = false)
	private LocalDateTime expDateTime;
	
	@Column(name = "exp_description", nullable = false, length = 200)
	private String expDescription;
	
	@Column(name = "exp_category", nullable = false, length = 50)
	private String expCategory;
	
	@Column(name = "exp_amount", nullable = false, precision = 10, scale = 2)
	private int expAmount;
	
	@Column(name = "exp_created_date_time", nullable = false)
	private LocalDateTime expCreatedDateTime;
	
}
