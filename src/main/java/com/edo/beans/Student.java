package com.edo.beans;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String stuName;
	private String stuSex;
	private int age;
	private Date cdate; 
	public Student() {
	}
	public Student(int id,String stuname,String sex,int age,Date date) {
		this.id=id;
		this.stuName=stuname;
		this.age=age;
		this.stuSex=sex;
		this.cdate=date;
	}
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
}
