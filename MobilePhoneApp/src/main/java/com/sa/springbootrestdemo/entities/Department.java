package com.sa.springbootrestdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //Default Constructor
@AllArgsConstructor //Parameterized Constructor
@Data //Getter and setter methods
public class Department {

	private long departmentId;
	
	private String departmentName;
	
	private String description;
	
	private boolean status;
	
	private String departmentEmail;
}
