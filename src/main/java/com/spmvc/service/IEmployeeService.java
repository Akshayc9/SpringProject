package com.spmvc.service;

import java.util.List;

import com.spmvc.model.EmployeeEn;

public interface IEmployeeService {

	 public String addEmployee(EmployeeEn employee);

	 public List<EmployeeEn> listEmployeess();
	 
	 public EmployeeEn getEmployee(int empid);
	 
	 public String deleteEmployee(int empid);

	 public String updateEmployee(EmployeeEn employee);
}

