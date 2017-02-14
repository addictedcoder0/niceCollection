package org.rudra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass22.UserDetails;

public class HibernateTester {

	public static void main(String[] args) {
				
		/**
		 * It reads the configuration file (cfg) and build the session factory object based on the configuration provided
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/**
		 *   CRUD operation
		 */
		//Create
		for(int i=0;i<10;i++){
			UserDetails user =  new UserDetails();
			user.setUserId(i);
			user.setUserName("user"+i);
			session.save(user);
			}
		//session.getTransaction().commit();
		//read
		UserDetails user4 = (UserDetails)session.get(UserDetails.class,5);
		System.out.println("username : "+user4.getUserName());
		
		//update
		user4.setUserName("updated user4 ");
		session.update(user4);
		user4=null;
		user4 = (UserDetails)session.get(UserDetails.class,5);
		System.out.println("username : "+user4.getUserName());
		
		//delete
		UserDetails user5 = (UserDetails)session.get(UserDetails.class,6);
		session.delete(user5);
		
		session.getTransaction().commit();
		session.close();
		
		/** using the sessionFactory to fetch the record by using the primary key , always reuse the session factory obj
		 *  because it is costly to create . 
		 */
		
	//	session = sessionFactory.openSession();
		
	//	session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		
	}

	
}