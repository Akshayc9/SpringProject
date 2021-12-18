package com.spmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spmvc.model.SkillEn;
import com.spmvc.utility.HibernateUtility;

@Repository
public class SkillDaoImpl implements ISkillDao {

	@Autowired
	private SessionFactory sFactory;
	
	private Session session = null;
	private Transaction tr = null;
	
	@Override
	public String saveSkill(SkillEn skillEn) {
		session = sFactory.openSession();
		tr = session.beginTransaction();
		try {
			if (skillEn != null) {
				session.saveOrUpdate(skillEn);
				return "Skill with "+skillEn.getSkId()+" Saved";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return "Problem in Saving Skill";
	}

	@Override
	public String deleteSkill(int skId) {
		session = sFactory.openSession();
		SkillEn sEn = session.get(SkillEn.class, skId);
		try {
			if (skId>0 && sEn!=null) {
				tr = session.beginTransaction();
				session.delete(sEn);
				return "Skill with ID " +skId+" Deleted";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return "Problem in Deleting Skill";
	}

	@Override
	public String updateSkill(SkillEn skillEn) {
		session = sFactory.openSession();
		tr = session.beginTransaction();
		try {
			session.update(skillEn);
			return "Skill ID " +skillEn.getSkId()+" updated successfully";
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return "Can not update skill";
	}

	@Override
	public SkillEn getSkill(int skId) {
		session = sFactory.openSession();
		tr = session.beginTransaction();
		try {
				SkillEn sEn = session.get(SkillEn.class, skId);
				return sEn;
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return null;
	}

	@Override
	public List<SkillEn> getAllSkills() {
		session = sFactory.openSession();
		List<SkillEn> skills = session.createCriteria(SkillEn.class).list();			
		if (skills.isEmpty()) {
			System.out.println("Nothing to display");
		}
		session.close();
		return skills;
	}

}
