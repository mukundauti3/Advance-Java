package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Student;
import com.demo.dao.StudentDao;
import com.demo.dao.StudentDaoImpl;

public class StudentServiceImpl implements StudentService{
	
	static StudentDao sDao;
	
	public StudentServiceImpl()
	{
		sDao=new StudentDaoImpl();
	}
	static Scanner sc=new Scanner(System.in);
	@Override
	public boolean addnewStudent() {
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Class of Student");
		String sclass=sc.next();
		
		return sDao.addNewStudent(id,name,sclass);
	}
	@Override
	public List<Student> addStudentData() {
		
		return sDao.seeStudentData();
	}
	@Override
	public Student seeById() {
		System.out.println("Enter the id to search");
		int id=sc.nextInt();
		return sDao.seeById(id);
	}
	@Override
	public boolean updateStudent() {
		System.out.println("Enter id to update Student Id");
		int id=sc.nextInt();
		
		System.out.println("Enter updated name of Student");
		String name=sc.next();
		
		System.out.println("Enter updated class of Student");
		String sclass=sc.next();
		
		return sDao.updateStudent(id,name,sclass);
	}
	@Override
	public boolean deleteById() {
		System.out.println("Enter the id to delete");
		int id=sc.nextInt();
		return sDao.deleteById(id);
	}
	@Override
	public void closeAll() {
		sc.close();
		sDao.closeAll();
	}

}
