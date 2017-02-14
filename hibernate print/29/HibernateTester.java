package org.rudra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass29.UserDetails;

public class HibernateTester {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		UserDetails storedUser_info = session1.get(UserDetails.class, 1);
		session1.getTransaction().commit();
		session1.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		UserDetails storedUser_info1 = session2.get(UserDetails.class, 1);
		session2.getTransaction().commit();
		session2.close();
		
		sessionFactory.close();
	
	}

	
}