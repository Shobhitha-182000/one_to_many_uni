package com.ty_one_to_many_uni_student_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

 
import com.ty_one_to_many_uni_student_dto.School;
import com.ty_one_to_many_uni_student_dto.Student;

public class StudentDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	//save
	public void saveSchool(List<Student>list,int sid) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School school=entityManager.find(School.class, sid);
		entityTransaction.begin();
		 
		 
		for(Student student1:list) {
			entityManager.persist(list);
		} 
	 
		entityTransaction.commit();
	}
	// update
	 public void updateSchool(int sid,Student student) {
		 EntityManager entityManager=getEntityManager();
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 School recieve=entityManager.find(School.class, sid);
		 entityTransaction.begin();
		 if(student!=null) {
			 student.setId(sid);;
			 
			 entityManager.merge(student);
			  
		 }
		 else
			 System.out.println("id not present");	
	 }
	
	//remove
		public void removeCompany(int sid) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			 Student student=entityManager.find(Student.class, sid);
			entityTransaction.begin();
			entityManager.remove(student);
			 
			entityTransaction.commit();
		}
		
		//getOne
		public Student getOneCompany(int sid) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			 Student student=entityManager.find(Student.class, sid);
			return student;
		}
		
		//getAll
		public List<Student> getAll(){
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			Query query=entityManager.createQuery("select e from Student e");
			List<Student> list=query.getResultList();
			return list;
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
