package org.rudra.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass9.Address;
import org.rudra.modelClass9.UserDetails;
import org.rudra.modelClass9.UserId;

public class HibernateTester {

	public static void main(String[] args) {
		UserId id1 = new UserId();
		id1.setId(1);
		UserId id2 = new UserId();
		id2.setId(2);
		
		UserDetails userDetails =  new UserDetails();
		UserDetails userDetails1 =  new UserDetails();
		/*userDetails.setUserId(2);*/
		
		Address addr = new Address();
		addr.setCity("chennai");
		addr.setPincode("603202");
		addr.setState("TN");
		addr.setStreet("GST");
		userDetails.setUserId(id1);
		userDetails.setUserName("abhishek");
		userDetails.setAddress(addr);
		userDetails.setDescription("Hibernate is adding some dummy data as LOB"
				+ "kjsdbvjksdbvhjbsdjbvhjdfhvbhdbfhvbhdfjvdf"
				+ "dfbvhjfdbvkjdfbjvdbfjvdbfkjvbkdjfvbjdfbvjkdbkfjvbkjdf"
				+ "hndfvkjdnfkjvndkjfnvjkdnxdfv"
				+ "kjdfnvkjdnfjkvnjdfnvjkdnfkjvjhdfvkjdfkjvkjdfnvkjndfkuvdfbhvjbdjfhyvbydfbvjhdfbvhdf"
				+ "jdkjfvnlap0kjOAUWDKAXAOIUOSJ JCNKXJNCHZSJNAKjnksduncshdhsds"
				+ "jhsdnfvkjsdmcjhdhcisndsmdhchjsmdkmskhdhnksjndvhdfsd"
				+ "hjasnciusdjk,msudjvmsjfjvmsjkfnvmd");
		userDetails.setJoinedDate(new Date());
		userDetails1.setUserId(id2);
		userDetails1.setUserName("rudra");
		userDetails1.setAddress(addr);
		userDetails1.setDescription("Hibernate is adding some dummy data as LOB"
				+ "kjsdbvjksdbvhjbsdjbvhjdfhvbhdbfhvbhdfjvdf"
				+ "dfbvhjfdbvkjdfbjvdbfjvdbfkjvbkdjfvbjdfbvjkdbkfjvbkjdf"
				+ "hndfvkjdnfkjvndkjfnvjkdnxdfv"
				+ "kjdfnvkjdnfjkvnjdfnvjkdnfkjvjhdfvkjdfkjvkjdfnvkjndfkuvdfbhvjbdjfhyvbydfbvjhdfbvhdf"
				+ "jdkjfvnlap0kjOAUWDKAXAOIUOSJ JCNKXJNCHZSJNAKjnksduncshdhsds"
				+ "jhsdnfvkjsdmcjhdhcisndsmdhchjsmdkmskhdhnksjndvhdfsd"
				+ "hjasnciusdjk,msudjvmsjfjvmsjkfnvmd");
		userDetails1.setJoinedDate(new Date());
		
		
		/**
		 * It reads the configuration file (cfg) and build the session factory object based on the configuration provided
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.save(userDetails1);
		session.getTransaction().commit();
		session.close();
		
		/** using the sessionFactory to fetch the record by using the primary key , always reuse the session factory obj
		 *  because it is costly to create . 
		 */
		session = sessionFactory.openSession();
		UserDetails storedUser_info = session.get(UserDetails.class, id2);
		System.out.println(storedUser_info.getUserId().getId());
		System.out.println(storedUser_info.getJoinedDate());
		System.out.println(storedUser_info.getDescription());
		System.out.println(storedUser_info.getAddress().getState());
		System.out.println(storedUser_info.getAddress().getStreet());
		System.out.println(storedUser_info.getAddress().getCity());
		System.out.println(storedUser_info.getUserName());
		session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		
	}
}