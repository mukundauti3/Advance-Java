package com.demo.dao;

import java.util.List;

import com.demo.beans.Student;

public interface StudentDao {

	boolean addNewStudent(int id, String name, String sclass);

	List<Student> seeStudentData();

	Student seeById(int id);

	boolean updateStudent(int id, String name, String sclass);

	boolean deleteById(int id);

	void closeAll();

}
