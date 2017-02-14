package org.rudra.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass29.UserDetails;

public class HibernateTester {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Query query = session1.createQuery("from UserDetails where userId = 5");
		query.setCacheable(true);
		List<UserDetails> storedUser_info = query.list();
		
		session1.getTransaction().commit();
		session1.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Query query1 = session2.createQuery("from UserDetails where userId = 5");
		query1.setCacheable(true);
		List<UserDetails> storedUser_info1 = query1.list();
		session2.getTransaction().commit();
		session2.close();
		
		sessionFactory.close();
	
	}

	
}