package com.bridglab.employeepayroll.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {
	
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee name Invalid") //validation added for name
	public String name;

	@Min(value=500,message="Min wage should be more than 500") //validation for salary added
	public long salary;

	public EmployeePayrollDTO(String name, long salary)  {
		super();
		this.name = name;
		this.salary = salary;
	}

	public EmployeePayrollDTO() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
}
