package com.spmvc.service;

import java.util.List;

import com.spmvc.model.SkillEn;

public interface ISkillService {

	//add
	public String addSkill(SkillEn skillEn);
	//delete
	public String removeSkill(int skId);
	//update
	public String modifySkill(SkillEn skillEn);
	//get/search skill
	public SkillEn showSkill(int skId);
	//get all skills
	public List<SkillEn> showAllSkills();
}
