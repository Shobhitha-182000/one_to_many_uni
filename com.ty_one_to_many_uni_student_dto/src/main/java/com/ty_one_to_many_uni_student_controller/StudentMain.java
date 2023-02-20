package com.ty_one_to_many_uni_student_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty_one_to_many_uni_student_dao.SchoolDao;
import com.ty_one_to_many_uni_student_dao.StudentDao;
import com.ty_one_to_many_uni_student_dto.School;
import com.ty_one_to_many_uni_student_dto.Student;

public class StudentMain {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		 
		StudentDao studentDao=new StudentDao();
		SchoolDao schoolDao=new SchoolDao();
		boolean flag=true;
		
		do {
			System.out.println("do you want 1.save school \n 2.update school \n 3.remove school \n 4.getone \n 5.get all \n 6.exit");
			System.out.println("choose any of one");
			int choose=scanner.nextInt();
			switch (choose) {
			case 1:{
				System.out.println("enter the School name");
				String name=scanner.next();
				
				System.out.println("enter the location");
				String address=scanner.next();
				
				School school =new School();
				school.setName(name);
				school.setLocation(address);
				
				System.out.println("enter the Student name :");
				String sname=scanner.next();
				
				System.out.println("enter the phone");
				long phone=scanner.nextLong();
				
				System.out.println("enter the address");
				String Saddress=scanner.next();
				
				System.out.println("enter the marks");
				String marks=scanner.next();
				
				Student s1=new Student();
				 
				
				s1.setName(name);
				s1.setMarks(marks);
				s1.setPhone(phone);
				s1.setAddress(address);
				
				 
				List<Student>list=new ArrayList<Student>();
				list.add(s1);
				
				school.setStudent(list);
				schoolDao.saveSchool(school);
				System.out.println("do you want to add more students click on 1.to add 2.exit");
				int select=scanner.nextInt();
				boolean repeat=true;
				do {
					switch (select) {
					case 1:{
						System.out.println("enter the Student name :");
						String s1name=scanner.next();
						
						System.out.println("enter the phone");
						long phone1=scanner.nextLong();
						
						System.out.println("enter the address");
						String Saddress1=scanner.next();
						
						System.out.println("enter the marks");
						String marks1=scanner.next();
						
						Student s4=new Student();
						
						System.out.println("enter the school id");
						int id=scanner.nextInt();
						
						s4.setName(s1name);
						s4.setMarks(marks1);
						s4.setPhone(phone1);
						s4.setAddress(Saddress);
						
						List<Student>list1=new ArrayList<Student>();
						list1.add(s4);
						studentDao.saveSchool(list1, id);
						System.out.println("inserted");
						
					}break;
					case 2:{
						repeat=false;
						System.out.println("Thank you");
					}break;

					default:
						break;
					}
					
				}while(repeat);
				
			}break;
			case 2:{
				
			}break;
			case 3:{
				
			}break;
			
			case 4:{
				
			}break;
			case 5:{
				
			}break;
			case 6:{
					flag=true;
					System.out.println("THANK YOU");
			}break;
			default:
				break;
			}
			
			
		}while(flag);
		
	}
}
