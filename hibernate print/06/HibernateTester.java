package org.rudra.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass6.UserDetails;

public class HibernateTester {

	public static void main(String[] args) {
		UserDetails userDetails =  new UserDetails();
		/*userDetails.setUserId(2);*/
		userDetails.setUserName("abhishek");
		userDetails.setAddress("India anywhere sdfsd");
		userDetails.setDescription("Hibernate is adding some dummy data as LOB"
				+ "kjsdbvjksdbvhjbsdjbvhjdfhvbhdbfhvbhdfjvdf"
				+ "dfbvhjfdbvkjdfbjvdbfjvdbfkjvbkdjfvbjdfbvjkdbkfjvbkjdf"
				+ "hndfvkjdnfkjvndkjfnvjkdnxdfv"
				+ "kjdfnvkjdnfjkvnjdfnvjkdnfkjvjhdfvkjdfkjvkjdfnvkjndfkuvdfbhvjbdjfhyvbydfbvjhdfbvhdf"
				+ "jdkjfvnlap0kjOAUWDKAXAOIUOSJ JCNKXJNCHZSJNAKjnksduncshdhsds"
				+ "jhsdnfvkjsdmcjhdhcisndsmdhchjsmdkmskhdhnksjndvhdfsd"
				+ "hjasnciusdjk,msudjvmsjfjvmsjkfnvmd");
		userDetails.setJoinedDate(new Date());
		/**
		 * It reads the configuration file (cfg) and build the session factory object based on the configuration provided
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		
		// using the sessionFactory to fetch the record by using the primary key
		session = sessionFactory.openSession();
		UserDetails storedUser_info = session.get(UserDetails.class, 1);
		System.out.println(storedUser_info.getUserId());
		System.out.println(storedUser_info.getJoinedDate());
		System.out.println(storedUser_info.getDescription());
		System.out.println(storedUser_info.getAddress());
		//System.out.println(storedUser_info.getUserName());
		session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		
	}
}
