package com.spmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmvc.dao.SkillDaoImpl;
import com.spmvc.model.SkillEn;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SkillServiceImpl implements ISkillService {

	@Autowired
	SkillDaoImpl skdao; 
	
	@Override
	public String addSkill(SkillEn skillEn) {
		return skdao.saveSkill(skillEn);
	}

	@Override
	public String removeSkill(int skId) {
		return skdao.deleteSkill(skId);
	}

	@Override
	public String modifySkill(SkillEn skillEn) {
		return skdao.updateSkill(skillEn);
	}

	@Override
	public SkillEn showSkill(int skId) {
		return skdao.getSkill(skId);
	}

	@Override
	public List<SkillEn> showAllSkills() {
		return skdao.getAllSkills();
	}

}
