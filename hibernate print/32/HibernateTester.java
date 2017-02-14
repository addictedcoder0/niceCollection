package org.rudra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass33.Admin;
import org.rudra.modelClass33.HardwareEngineer;
import org.rudra.modelClass33.SoftwareEngineer;

public class HibernateTester {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		SoftwareEngineer se =  new SoftwareEngineer(111, "rudra", "rudra@gmail.com", 1000000, "hibernate");
		HardwareEngineer he = new HardwareEngineer(222, "sanjeev", "sanjeev@gmail.com", 20000, 12);
		Admin admin = new Admin(333, "jagan", "jagan@gmail.com", 10000, "C.S.E");
				
		session1.save(se);
		session1.save(he);
		session1.save(admin);
		session1.getTransaction().commit();
		session1.close();
		sessionFactory.close();
	}
}