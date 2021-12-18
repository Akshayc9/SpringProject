package com.spmvc.dao;

import java.util.List;

import com.spmvc.model.SkillEn;

public interface ISkillDao {

	//add
	public String saveSkill(SkillEn skillEn);
	//delete
	public String deleteSkill(int skId);
	//update
	public String updateSkill(SkillEn skillEn);
	//get/search skill
	public SkillEn getSkill(int skId);
	//get all skills
	public List<SkillEn> getAllSkills();
}
