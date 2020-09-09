package com.impelsys.model;



public class StudentModel
{
	private int roll;
	private String name;
	private String fathername;
	private String degree;
	private String branch;
	public StudentModel()
	{

	}
	public StudentModel(int roll, String name, String fathername, String degree, String branch) {
		super();
		this.roll = roll;
		this.name = name;
		this.fathername = fathername;
		this.degree = degree;
		this.branch = branch;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}





}