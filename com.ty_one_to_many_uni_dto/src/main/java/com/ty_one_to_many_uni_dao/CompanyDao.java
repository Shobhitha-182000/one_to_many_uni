package com.ty_one_to_many_uni_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

 
import com.ty_one_to_many_uni_dto.Comapny;
import com.ty_one_to_many_uni_dto.Employee;

public class CompanyDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	
	//save
	public void saveCompany(Comapny company) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		
		List<Employee> employee=company.getList();
		for(Employee emp:employee) {
			entityManager.persist(emp);
		}
		 
		entityManager.persist(company);
		 
		entityTransaction.commit();
	}
	
	//update
	public void updateCompany(int cid,Comapny comapny) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Comapny recieveCompany=entityManager.find(Comapny.class, cid);
		
		if(comapny!=null) {
		comapny.setCid(cid);
		//comapny.setList(recieveCompany.getList());
		entityTransaction.begin();
		
		entityManager.merge(comapny);
		entityTransaction.commit();
		}
		else {
			System.out.println("id is not present");
		}
	}
	
	//remove
	public void removeCompany(int cid) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Comapny comapny=entityManager.find(Comapny.class,cid);
		entityTransaction.begin();
		entityManager.remove(comapny);
		entityManager.remove(comapny.getList());
		entityTransaction.commit();
	}
	
	//getOne
	public Comapny getOneCompany(int eid) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Comapny comapny=entityManager.find(Comapny.class, eid);
	 
		return comapny;
	}
	
	//getAll
	public List<Comapny> getAllCompany(){
		EntityManager entityManager=getEntityManager();

		Query query=entityManager.createQuery("select e from Comapny e");
		List<Comapny> list=query.getResultList();
		return list;
		
	}
	
	
	
	
	
}
