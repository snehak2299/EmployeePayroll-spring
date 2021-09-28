package com.bridglab.employeepayroll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridglab.employeepayroll.dto.EmployeePayrollDTO;
import com.bridglab.employeepayroll.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	private List<EmployeePayrollData> employeePayrollList=new ArrayList<>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		
		List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
		employeePayrollList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",3000)));
		
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataNyId(int empId) {
	
		
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",3000));
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
	
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(2,empPayrollDTO);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updatedEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
	
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(empId,empPayrollDTO);
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		

	}
}
