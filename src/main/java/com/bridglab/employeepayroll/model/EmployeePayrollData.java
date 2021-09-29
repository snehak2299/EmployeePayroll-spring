package com.bridglab.employeepayroll.model;

import java.time.LocalDate;
import java.util.List;

import com.bridglab.employeepayroll.dto.EmployeePayrollDTO;

import lombok.Data;

public @Data class EmployeePayrollData {
	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> departments;
	

	public EmployeePayrollData(int employeeId,EmployeePayrollDTO empPayrollDTO) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.startDate = startDate;
		this.note = note;
		this.profilePic = profilePic;
		this.departments = departments;
	}
	
	
}
