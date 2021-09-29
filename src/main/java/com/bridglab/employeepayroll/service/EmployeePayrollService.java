package com.bridglab.employeepayroll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridglab.employeepayroll.dto.EmployeePayrollDTO;
import com.bridglab.employeepayroll.exception.EmployeePayrollException;
import com.bridglab.employeepayroll.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	private List<EmployeePayrollData> employeePayrollList=new ArrayList<>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataNyId(int empId) {
		
		return employeePayrollList.stream().filter(empData->empData.getEmployeeId()==empId)
				.findFirst()
				.orElseThrow(()->new EmployeePayrollException("Employee not found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		// TODO Auto-generated method stub
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(employeePayrollList.size()+1,empPayrollDTO);
		employeePayrollList.add(employeePayrollData);
		return employeePayrollData;
	}


	@Override
	public EmployeePayrollData updatedEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		
		EmployeePayrollData empData=this.getEmployeePayrollDataNyId(empId);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeePayrollList.set(empId-1, empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId-1);

	}

}
