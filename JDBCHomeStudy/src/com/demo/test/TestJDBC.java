package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Student;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;

public class TestJDBC {
	

	public static void main(String[] args) {
		StudentService sService=new StudentServiceImpl();
		
		
		
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		do {
		System.out.println("1) Add New Student");
		System.out.println("2)See All Student");
		System.out.println("3)See by id");
		System.out.println("4)Update Student by ID");
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1->{
				System.out.println("Enter the Details of new Student");
				boolean check=sService.addnewStudent();
			}
			
			case 2->{
				List<Student> sList=sService.addStudentData();
				sList.forEach(System.out::println);
			}
			
			case 3->{
				Student s=sService.seeById();
				System.out.println(s);
			}
			case 4->{
				boolean check=sService.updateStudent();
				if(check)
				{
					System.out.println("Updated");
				}else {
					System.out.println("Not Updated");
				}
			}
			
			case 5->{
				boolean check=sService.deleteById();
				if(check)
				{
					System.out.println("Deleted");
				}else {
					System.out.println("Not Deleted");
				}
			}
			
			case 6->{
				sc.close();
				sService.closeAll();
				
			}
			
			}
		}while(choice<=6);

	}

}
