package com.mahder.hibernate.manytomanystudy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_COURSE")
public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COURSE_ID")
	@GeneratedValue
	private int id;
	
	@Column(name="COURSE_NUMBER")
	private String courseNumber;
	
	@Column(name="COURSE_TITLE")
	private String courseTitle;
	
	@Column(name="CREDIT_HOURS")
	private int creditHours;
	
	@ManyToMany(mappedBy="courseList")//courseList is the name of the datamember
	//found in Student.java...
	private List<Student> studentList = new ArrayList<Student>();

	public Course() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}// end class
