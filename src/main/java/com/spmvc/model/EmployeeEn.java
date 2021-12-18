package com.spmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private Integer empId;

	@Column(nullable = false, name = "EMPLOYEE_NAME")
	private String empName;
	
	@Column(nullable = false, name = "EMPLOYEE_AGE")
	private Integer empAge;
	
	@Column(nullable = false, name = "EMPLOYEE_GENDER")
	private String empGender;
	
	@Column(nullable = false, name = "EMPLOYEE_SALARY")
	private Long empSalary;
	
	@Column(nullable = false, name = "EMPLOYEE_ADDRESS")
	private String empAddress;
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employeeEns", orphanRemoval = true, targetEntity = SkillEn.class)
	@OneToMany(cascade = CascadeType.ALL, targetEntity = SkillEn.class, mappedBy = "employeeEns" )
	
//    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "Employee_Skills", 
//        joinColumns = { @JoinColumn(name = "emp_id", referencedColumnName = "EMPLOYEE_ID") }, 
//        inverseJoinColumns = { @JoinColumn(name = "sk_id", referencedColumnName = "SKILL_ID") }
//    )
	private List<SkillEn> empSkills;

	public EmployeeEn(String empName, Integer empAge, String empGender, Long empSalary, String empAddress,
			List<SkillEn> empSkills) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.empGender = empGender;
		this.empSalary = empSalary;
		this.empAddress = empAddress;
		this.empSkills = empSkills;
	}
}

