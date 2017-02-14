package org.rudra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass23.UserDetails;

public class HibernateTester {

	public static void main(String[] args) {
				
		/**
		 * It reads the configuration file (cfg) and build the session factory object based on the configuration provided
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/**                  Detached Object to Persistent   	 */
		//Create and Fetch 
		for(int i=0;i<2;i++){
			UserDetails user =  new UserDetails();
			user.setUserId(i);
			user.setUserName("user"+i);
			session.save(user);
			}
		UserDetails user = (UserDetails)session.get(UserDetails.class,1);
		System.out.println("username : "+user.getUserName());
		// close the connection
		session.getTransaction().commit();
		session.close();
		
		/**"user" is now Detached object , try to update it
		 * always try to use the @SelectBeforeUpdate on entity classes , as it saves HF from false update
		*/
		user.setUserName("updated user ");// if this line is commented then no update will happen
		
		//open the session again.
		session = sessionFactory.openSession();
		session.beginTransaction();
		// due to @SelectBeforeUpdate , HF will select the object and match it with the current object before updation
		
		session.update(user);
		user = null;
		user = (UserDetails)session.get(UserDetails.class,1);
		System.out.println("username : "+user.getUserName());
		
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