package org.rudra.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass37.Course;
import org.rudra.modelClass37.Faculty;

public class HibernateTester {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();

		Course c1= new Course();
		c1.setCourse_id(1);
		c1.setCourse_name("spring_framework");
		c1.setCourse_fee(5000);
		
		Course c2= new Course();
		c2.setCourse_id(2);
		c2.setCourse_name("spring_boot");
		c2.setCourse_fee(5000);
		
		Course c3= new Course();
		c3.setCourse_id(3);
		c3.setCourse_name("Hibernate");
		c3.setCourse_fee(3000);
		
		Faculty f1= new Faculty();
		f1.setId(1);
		f1.setName("Raj");
		f1.setExperience(4);
		
		Set<Course> f1_courses = new HashSet<>();
		f1_courses.add(c1);
		f1_courses.add(c2);
		f1.setCourses(f1_courses);
		
		Faculty f2= new Faculty();
		f2.setId(2);
		f2.setName("jayram");
		f2.setExperience(4);
		
		Set<Course> f2_courses = new HashSet<>();
		f2_courses.add(c2);
		f2.setCourses(f2_courses);
				
		Faculty f3= new Faculty();
		f3.setId(3);
		f3.setName("Rohini");
		f3.setExperience(3);
		
		Set<Course> f3_courses = new HashSet<>();
		f3_courses.add(c1);
		f3_courses.add(c3);
		f3.setCourses(f3_courses);
		
		session1.save(c1);
		session1.save(c2);
		session1.save(c3);
		session1.save(f1);
		session1.save(f2);
		session1.save(f3);
		
		session1.getTransaction().commit();
		session1.close();
		sessionFactory.close();
	}
}