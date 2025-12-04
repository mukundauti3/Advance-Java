package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Student;

public class StudentDaoImpl implements StudentDao{
	
	static Connection con;
	static PreparedStatement insertStudent,selectQuery,selectById,updateById,deleteById;
	static {
		con=DBUtil.getMyConnection();
		try {
			insertStudent=con.prepareStatement("insert into Student1 values(?,?,?)");
			selectQuery=con.prepareStatement("select * from Student1");
			selectById=con.prepareStatement("select * from student1 where id=?");
			updateById=con.prepareStatement("update student1 set name=?, class=? where id=?");
			deleteById=con.prepareStatement("DELETE FROM student1 WHERE id=?");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public boolean addNewStudent(int id, String name, String sclass) {
		try {
			insertStudent.setInt(1, id);
			insertStudent.setString(2, name);
			insertStudent.setString(3, sclass);
			int num = insertStudent.executeUpdate();
			return num > 0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Student> seeStudentData() {
		List<Student> sList=new ArrayList<>();
		
		try {
			ResultSet rs=selectQuery.executeQuery();
			while(rs.next())
			{
				sList.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			return sList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student seeById(int id) {
		try {
			selectById.setInt(1, id);
			ResultSet rs=selectById.executeQuery();
			if(rs!=null)
			{
				Student s=new Student(rs.getInt(1),rs.getString(2),rs.getString(3));
				return s;
			}else {
				System.out.println("ID Not Found");
				return null;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateStudent(int id, String name, String sclass) {
		try {
			updateById.setInt(3, id);
			updateById.setString(1, name);
			updateById.setString(2, sclass);
			
			int num=updateById.executeUpdate();
			return num > 0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(int id) 
	{
		try {
			deleteById.setInt(1, id);
			
			int n=deleteById.executeUpdate();
			return n==0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void closeAll() {
		DBUtil.getCloseMyConnection();
		
	}

}
