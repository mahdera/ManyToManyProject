/**
 * 
 */
package com.mahder.hibernate.manytomanystudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alemayehu
 *
 */
public class TestManyToManyRelationship {
	public static void main(String[] args){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student student1 = new Student();
		Student student2 = new Student();
		//set student values...
		student1.setIdNumber("ISE/1234/00");
		student1.setFullName("Mahder Neway");
		student2.setIdNumber("ILE/2345/34");
		student2.setFullName("Lekbir Gebretsadik");
		Course course1 = new Course();
		Course course2 = new Course();
		course1.setCourseNumber("INSY 123");
		course1.setCourseTitle("OOP with Java");
		course1.setCreditHours(3);
		course2.setCourseNumber("INSER 423");
		course2.setCourseTitle("Introduction to Internet Programming");
		course2.setCreditHours(4);
		//now assign values to each other since its many to many
		student1.getCourseList().add(course1);
		student1.getCourseList().add(course2);
		student2.getCourseList().add(course1);
		student2.getCourseList().add(course2);
		//do the same for the course part....
		course1.getStudentList().add(student1);
		course1.getStudentList().add(student2);
		course2.getStudentList().add(student1);
		course2.getStudentList().add(student2);
		//now persist these objects to the database...
		session.save(student1);
		session.save(student2);
		session.save(course1);
		session.save(course2);
		session.getTransaction().commit();
		session.close();
		System.out.println("Finished Saving Data to the database...");
	}
}//end class
