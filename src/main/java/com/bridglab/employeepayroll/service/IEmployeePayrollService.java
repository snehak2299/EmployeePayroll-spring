package com.bridglab.employeepayroll.service;

import java.util.List;

import com.bridglab.employeepayroll.dto.EmployeePayrollDTO;
import com.bridglab.employeepayroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	 List<EmployeePayrollData> getEmployeePayrollData();
	 EmployeePayrollData getEmployeePayrollDataById(int empId);
	 EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
	 EmployeePayrollData updatedEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO);
	 void deleteEmployeePayrollData(int empId);
	 List<EmployeePayrollData>getEmployeesByDepartment(String department);
		
}
