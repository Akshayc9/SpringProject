package com.spmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spmvc.model.EmployeeEn;
import com.spmvc.utility.HibernateUtility;


@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private SessionFactory sFactory;
	
	private Session session = null;
	private Transaction tr = null;
	
	@Override
	public String addEmployee(EmployeeEn employee) {

		session = sFactory.openSession();
		tr = session.beginTransaction();
		try {
			if (employee != null) {
				session.saveOrUpdate(employee);
				return "Employee ID " +employee.getEmpId()+" saved successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return "Can not save employee";
	}

	@Override
	public List<EmployeeEn> listEmployeess() {
		session = sFactory.openSession();
		List<EmployeeEn> list = session.createCriteria(EmployeeEn.class).list();
		if (list.isEmpty()) {
			System.out.println("List is Empty");
		}
		session.close();
		return list;
	}

	@Override
	public EmployeeEn getEmployee(int empid) {
		session = sFactory.openSession();
		tr = session.beginTransaction();
		try {
			EmployeeEn emp = session.get(EmployeeEn.class, empid);
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return null;
	}

	@Override
	public String deleteEmployee(int empid) {
		session = sFactory.openSession();
		tr = session.beginTransaction();
		try {
			EmployeeEn emp = session.get(EmployeeEn.class, empid);
			session.delete(emp);
			return "Employee ID " +emp.getEmpId()+" deleted successfully";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return "Can not delete employee";
	}

	@Override
	public String updateEmployee(EmployeeEn employee) {
		session = sFactory.openSession();
		tr = session.beginTransaction();
		try {
			session.update(employee);
			return "Employee ID " +employee.getEmpId()+" updated successfully";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return "Can not update employee";
	}

}
