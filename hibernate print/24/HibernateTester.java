package org.rudra.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass24.UserDetails;

public class HibernateTester {

	public static void main(String[] args) {
				
		/**
		 * It reads the configuration file (cfg) and build the session factory object based on the configuration provided
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Create table and populate it . 
		for(int i=0;i<10;i++){
			UserDetails user =  new UserDetails();
			user.setUserId(i);
			user.setUserName("user"+i);
			session.save(user);
			}
		
		Query selectQuery = session.createQuery("from UserDetails");
		Query whereQuery = session.createQuery("from UserDetails where userId > 5");
		Query selectWithColumn = session.createQuery("select userName from UserDetails");
		/**
		 *  Pagination : to restrict the number of records pulled up
		 */
		selectQuery.setFirstResult(4);// it means skip upto 4 rows
		selectQuery.setMaxResults(3);// it specifies the range , means pull up 3 records alone on one call
		selectWithColumn.setFirstResult(5);
		selectWithColumn.setMaxResults(4);
		List selectQueryList = selectQuery.list();
		List whereQueryList = whereQuery.list();
		List<String> selectWithColumnQueryList = selectWithColumn.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		System.out.println(" Select Query List ["+ selectQueryList.size() +"]: "+selectQueryList.toString());
		System.out.println(" Where Query List ["+ whereQueryList.size() +"]: "+whereQueryList.toString());
		System.out.println(" Select Query with ColumnName List ["+ selectWithColumnQueryList.size() +"]: "+selectWithColumnQueryList.toString());
	}

	
}