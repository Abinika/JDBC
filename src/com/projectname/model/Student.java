package com.projectname.model;

public class Student {
	private int RollNo;
	private String Name;
	private int Age;
	private String Department;

	public Student(int rollNo, String name, int age, String department) {
		super();
		RollNo = rollNo;
		Name = name;
		Age = age;
		Department = department;
	}

	public int getRollNo() {
		return RollNo;
	}

	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public void save(Student student) {
		// TODO Auto-generated method stub
		
	}

}

