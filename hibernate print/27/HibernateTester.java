package org.rudra.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.rudra.modelClass27.UserDetails;

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
		/**
		 *  Criteria is similar to where clause
		 */
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userId",6));
		List<UserDetails> userList = criteria.list();
		
		Criteria criteria1 = session.createCriteria(UserDetails.class);
		criteria1.add(Restrictions.ge("userId",6))
				 .add(Restrictions.lt("userId",9));
		List<UserDetails> userList1 = criteria1.list();
		
		Criteria criteria2 = session.createCriteria(UserDetails.class);
		criteria2.add(Restrictions.like("userName","%user%"))
				 .add(Restrictions.between("userId", 5,8));
		List<UserDetails> userList2 = criteria2.list();
		
		Criteria criteria3 = session.createCriteria(UserDetails.class);
		criteria3.add(Restrictions.or(Restrictions.between("userId", 1,3), Restrictions.between("userId", 5,9)));
		List<UserDetails> userList3 = criteria3.list();
		
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		
		for(UserDetails user : userList){
			System.out.println(" "+user.getUserName());
		}
		System.out.println("************* multiple restrictions *************");
		for(UserDetails user : userList1){
			System.out.println(" "+user.getUserName());
		}
		System.out.println("************* like and between restrictions *************");
		for(UserDetails user : userList2){
			System.out.println(" "+user.getUserName());
		}
		System.out.println("************* Or clause restrictions *************");
		for(UserDetails user : userList3){
			System.out.println(" "+user.getUserName());
		}
		
	}

	
}