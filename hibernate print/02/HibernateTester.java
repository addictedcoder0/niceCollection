package org.rudra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass2.UserDetails;

public class HibernateTester {

	public static void main(String[] args) {
		UserDetails userDetails =  new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("abhishek");
		/**
		 * It reads the configuration file (cfg) and build the session factory object based on the configuration provided
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
	}
}
