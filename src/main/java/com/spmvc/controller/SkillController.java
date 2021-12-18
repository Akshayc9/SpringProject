package com.spmvc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spmvc.model.SkillEn;
import com.spmvc.service.SkillServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/skill")
public class SkillController {

	@Autowired
	SkillServiceImpl skService;
	
	private static final HashMap<String, Object> model = new HashMap<String, Object>();
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView addSkill() {
		model.put("skill", new SkillEn());
		model.put("message", "::Skill Set::");
		return new ModelAndView("skillwelcome",model);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView addNewSkill(@ModelAttribute("skill") SkillEn skillEn) {
		model.put("message", skService.addSkill(skillEn));
		model.put("skill", new SkillEn());
		return new ModelAndView("skillwelcome",model);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showSkill() {
		model.put("sklist",skService.showAllSkills());
		return new ModelAndView("showskills",model);
	}

	@RequestMapping(value = "/delete/{skid}", method = RequestMethod.GET)
	public ModelAndView deleteSkill(@PathVariable("skid") int skid) {
		model.put("message", skService.removeSkill(skid));
		model.put("sklist",skService.showAllSkills());
		return new ModelAndView("showskills",model);
	}

	@RequestMapping(value = "/edit/{skid}", method = RequestMethod.GET)
	public ModelAndView updateSkill(@PathVariable("skid") int skid) {
		model.put("skill", skService.showSkill(skid));
		return new ModelAndView("skillup",model);
	}

		@RequestMapping(value = "/edit", method = RequestMethod.POST)
		public ModelAndView changeSkill(@ModelAttribute(name = "skill") SkillEn skillEn) {
			model.put("message", skService.modifySkill(skillEn));
			model.put("sklist",skService.showAllSkills());
			return new ModelAndView("skillup",model);
		}
		
}
