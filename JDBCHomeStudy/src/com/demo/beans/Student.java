package com.demo.beans;

public class Student {
	
	private int sId;
	private String sName;
	private String sClass;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	public Student() {
		super();
	}
	public Student(int sId, String sName, String sClass) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sClass = sClass;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sClass=" + sClass + "]";
	}
	
	

}
