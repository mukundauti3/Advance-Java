package com.demo.service;

import java.util.List;

import com.demo.beans.Student;

public interface StudentService {

	boolean addnewStudent();

	List<Student> addStudentData();

	Student seeById();

	boolean updateStudent();

	boolean deleteById();

	void closeAll();

}
