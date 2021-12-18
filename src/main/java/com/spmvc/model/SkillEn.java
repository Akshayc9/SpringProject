package com.spmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SKILLS")
public class SkillEn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SKILL_ID")
	private Integer skId;
	
	@Column(name = "SKILL_NAME", nullable = false)
	private String skName;

	//@ManyToMany(fetch = FetchType.LAZY)
	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = EmployeeEn.class)
	//@JoinColumn(name = "SKILL_EMP")
	// @ManyToMany(mappedBy = "empSkills", fetch = FetchType.EAGER)
	@ManyToOne(targetEntity = EmployeeEn.class, cascade = CascadeType.PERSIST)
	private List<EmployeeEn> employeeEns;

	public SkillEn(String skName) {
		super();
		this.skName = skName;
	}

	@Override
	public String toString() {
		return "SkillEn [skId=" + skId + ", skName=" + skName + "]";
	}
	
	
	
	
}
