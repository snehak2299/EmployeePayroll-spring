package com.bridglab.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(EmployeePayrollAppApplication.class, args);
		log.info("Employee Payroll App started in {} Envoronment",
				context.getEnvironment().getProperty("environment")); // which environment using
		log.info("payroll service DB User is {}",
				context.getEnvironment().getProperty("spring.datasource.username")); //check username updated or not
	}

}
