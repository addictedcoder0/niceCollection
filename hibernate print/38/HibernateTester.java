package org.rudra.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass37.Course;
import org.rudra.modelClass37.Faculty;
import org.rudra.modelClass38.Employee;

public class HibernateTester {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();

		Employee emp1 = new Employee();
		emp1.setFirstName("aadsa");
		emp1.setLastName("dcdc");
		
		Employee emp2 = new Employee();
		emp2.setFirstName("bbbbbdsa");
		emp2.setLastName("jhgvhgvhdcdc");
			
		session1.save(emp1);
		session1.save(emp2);
		session1.getTransaction().commit();
		session1.close();
		sessionFactory.close();
	}
}