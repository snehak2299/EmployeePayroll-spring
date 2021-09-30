package com.bridglab.employeepayroll.EmployeePayrollRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bridglab.employeepayroll.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository <EmployeePayrollData ,Integer> {

}
