package com.ty_one_to_many_uni_student_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_one_to_many_uni_student_dto.School;
import com.ty_one_to_many_uni_student_dto.Student;

public class SchoolDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	//save
	public void saveSchool(School school) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		List<Student> students= school.getStudent();
		for(Student student:students) {
			entityManager.persist(student);
		}
		entityManager.persist(school);
		entityTransaction.commit();
	}
	// update
	 public void updateSchool(int sid,School school) {
		 EntityManager entityManager=getEntityManager();
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 School recieve=entityManager.find(School.class, sid);
		 entityTransaction.begin();
		 if(school!=null) {
			 school.setSid(sid);
			 school.setStudent(recieve.getStudent());
			 entityManager.merge(school);
			 entityManager.merge(school.getStudent());
		 }
		 else
			 System.out.println("id not present");	
	 }
	
	//remove
		public void removeCompany(int sid) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			 School school=entityManager.find(School.class, sid);
			entityTransaction.begin();
			entityManager.remove(school);
			entityManager.remove(school.getStudent());
			entityTransaction.commit();
		}
		
		//getOne
		public School getOneCompany(int sid) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			School school=entityManager.find(School.class, sid);
			return school;
		}
		
		//getAll
		public List<School> getAll(){
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			Query query=entityManager.createQuery("select e from School e");
			List<School> list=query.getResultList();
			return list;
		}
		
}
