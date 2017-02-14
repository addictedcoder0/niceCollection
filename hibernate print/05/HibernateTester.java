package org.rudra.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass5.UserDetails;

public class HibernateTester {

	public static void main(String[] args) {
		UserDetails userDetails =  new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("abhishek");
		userDetails.setAddress("India anywhere");
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
	}
}
