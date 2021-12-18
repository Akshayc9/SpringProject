package com.spmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spmvc.model.EmployeeEn;
import com.spmvc.service.EmployeeServiceImpl;
import com.spmvc.service.SkillServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/employee")
@AllArgsConstructor
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl empService;
	
	@Autowired
	SkillServiceImpl skService;
	
	private static final Map<String, Object> model = new HashMap<String, Object>();
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		model.put("message", "::WELCOME::");
		return new ModelAndView("home",model);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		model.put("employee", new EmployeeEn());
		model.put("sklist", skService.showAllSkills());
		model.put("emplist", empService.listEmployeess());
		return new ModelAndView("newemp",model);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute(name = "employee") EmployeeEn employee) {
			System.out.println(employee);
			model.put("message", empService.addEmployee(employee));
			model.put("employee", new EmployeeEn());
			model.put("sklist", skService.showAllSkills());
		return new ModelAndView("newemp",model);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showEmployee() {
		if (empService.listEmployeess().isEmpty()) {
			model.put("message", "List is Empty");
		} else {
			model.put("sklist", skService.showAllSkills());
			model.put("emplist", empService.listEmployeess());
		}
		return new ModelAndView("empslist", model);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchEmployee() {
		model.put("employee", new EmployeeEn());
		return new ModelAndView("empsearch", model);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView getEmployee(@ModelAttribute(name = "employee") EmployeeEn employee) {
		EmployeeEn emp = empService.getEmployee(employee.getEmpId());
		if (emp!= null) {
			System.out.println(emp);
			model.put("message", "Employee with " +employee.getEmpId()+" found in the list");
			model.put("employee", empService.getEmployee(employee.getEmpId()));
		} else {
			model.put("message", "Employee with " +employee.getEmpId()+" not found in the list");
		}
		return new ModelAndView("empsearch", model);
	}
	
	@RequestMapping(value = "/delete/{empid}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable(name = "empid") int empid) {
		model.put("message", empService.deleteEmployee(empid));
		model.put("emplist", empService.listEmployeess());
		return new ModelAndView("empslist", model);
	}
	
	@RequestMapping(value = "/update/{empid}", method = RequestMethod.GET)
	public ModelAndView updateEmployee(@PathVariable(name = "empid") int empid) {
		model.put("employee", empService.getEmployee(empid));
//		model.put("skill", skService.showAllSkills());
		return new ModelAndView("updateemp", model);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute(name = "employee") EmployeeEn employee) {
		model.put("message", empService.updateEmployee(employee));
		model.put("emplist", empService.listEmployeess());
		return new ModelAndView("updateemp", model);
	}
}
