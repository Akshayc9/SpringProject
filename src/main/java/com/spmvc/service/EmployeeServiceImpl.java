package com.spmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmvc.dao.EmployeeDaoImpl;
import com.spmvc.model.EmployeeEn;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeDaoImpl empdao;
	
	@Override
	public String addEmployee(EmployeeEn employee) {
		return empdao.addEmployee(employee);
	}

	@Override
	public List<EmployeeEn> listEmployeess() {
		return empdao.listEmployeess();
	}

	@Override
	public EmployeeEn getEmployee(int empid) {
		return empdao.getEmployee(empid);
	}

	@Override
	public String deleteEmployee(int empid) {
		return empdao.deleteEmployee(empid);
	}

	@Override
	public String updateEmployee(EmployeeEn employee) {
		return empdao.updateEmployee(employee);
	}

}
