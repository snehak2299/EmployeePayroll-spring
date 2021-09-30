package com.bridglab.employeepayroll.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridglab.employeepayroll.EmployeePayrollRepository.EmployeePayrollRepository;
import com.bridglab.employeepayroll.dto.EmployeePayrollDTO;
import com.bridglab.employeepayroll.exception.EmployeePayrollException;
import com.bridglab.employeepayroll.model.EmployeePayrollData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;
	

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		
		return employeePayrollRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollRepository
				.findById(empId)
				.orElseThrow(()->new EmployeePayrollException("Employee with empId"+empId+"doesn't exits..!!"));
	
	
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
		employeePayrollRepository.delete(empData);	
	}
	
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empDTO) {
		EmployeePayrollData empData=null;
		empData=new EmployeePayrollData(empDTO);
		
		log.debug("Employee Data"+empData.toString());
		return employeePayrollRepository.save(empData);	
	}

	
	@Override
	public EmployeePayrollData updatedEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
		empData.updateEmployeePayrollData(empPayrollDTO);
		return employeePayrollRepository.save(empData);
	}

}
