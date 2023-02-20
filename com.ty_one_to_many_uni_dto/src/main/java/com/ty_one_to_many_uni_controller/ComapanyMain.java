package com.ty_one_to_many_uni_controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty_one_to_many_uni_dao.CompanyDao;
import com.ty_one_to_many_uni_dto.Comapny;
import com.ty_one_to_many_uni_dto.Employee;

public class ComapanyMain {
	public static void main(String[] args) {
		
//		Employee e=new Employee();
//		e.setName("Shobhitha");
//		e.setAddress("hsn");
//		e.setPhone(32676546);
//		
//		Employee e1=new Employee();
//		e1.setName("Priya");
//		e1.setAddress("ckm");
//		e1.setPhone(7868585);
//		
//		Employee e2=new Employee();
//		e2.setName("Raju");
//		e2.setPhone(4636586);
//		e2.setAddress("BLR");
//		
	Comapny company=new Comapny();
		company.setCompany_name("Test");
//		company.setGst("ab123");
//		
//		List<Employee> list=new ArrayList<Employee>();
//		list.add(e);
//		list.add(e1);
//		list.add(e2);
		
	//	company.setList(list);
		
//		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction=entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(e);
//		entityManager.persist(e1);
//		entityManager.persist(e2);
//		entityManager.persist(company);
//		entityTransaction.commit();
		
		
		CompanyDao dao=new CompanyDao();
		dao.updateCompany(2, company);
		
	}
}
