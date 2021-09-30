package com.bridglab.employeepayroll.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.bridglab.employeepayroll.dto.EmployeePayrollDTO;

import lombok.Data;

@Entity
@Table(name="employee_payroll")
public @Data class EmployeePayrollData {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_id")
	private int employeeId;
	
	
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	
	@ElementCollection
	@CollectionTable(name="employee_department",joinColumns=@JoinColumn(name="id"))
	@Column(name="department")
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
