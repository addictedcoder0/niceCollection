package org.rudra.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass25.UserDetails;

public class HibernateTester {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for(int i=0;i<10;i++){
			UserDetails user =  new UserDetails();
			user.setUserId(i);
			user.setUserName("user"+i);
			session.save(user);
			}
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		String idBoundary = "5"; // if try to do SQL injection , will throw Exception.
		//Query parameterisedQuery = session.createQuery("from UserDetails where userId > ? ");
		Query parameterisedQuery = session.createQuery("from UserDetails where userId > :userId ");
	//	parameterisedQuery.setInteger(0,Integer.parseInt(idBoundary)); // first arg defines the position
		parameterisedQuery.setInteger("userId",Integer.parseInt(idBoundary)); // first arg defines the Attribute
		List<UserDetails> userList = parameterisedQuery.list();
		
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		
		for(UserDetails user : userList){
			System.out.println(" "+user.getUserName());
		}
		
	}

	
}