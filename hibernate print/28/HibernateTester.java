package org.rudra.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.rudra.modelClass28.UserDetails;

public class HibernateTester {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for(int i=0;i<=10;i++){
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
		 *  Projection : used for grouping or aggregation
		 */
		Criteria criteria = session.createCriteria(UserDetails.class)
				.addOrder(Order.desc("userId"));
		List<UserDetails> userList = criteria.list();
		
		Criteria criteria1 = session.createCriteria(UserDetails.class)
				.setProjection(Projections.count("userName"));
		
		List<Long> userList1 = criteria1.list();
		
		Criteria criteria2 = session.createCriteria(UserDetails.class)
				.setProjection(Projections.count("userId"));;
		
		List<Long> userList2 = criteria2.list();
		
		Criteria criteria3 = session.createCriteria(UserDetails.class);
		criteria3.add(Restrictions.or(Restrictions.between("userId", 1,3), Restrictions.between("userId", 5,9)));
		List<UserDetails> userList3 = criteria3.list();
		
		Criteria criteria4 = session.createCriteria(UserDetails.class)
				.setProjection(Projections.property("userId"))
				.addOrder(Order.desc("userId"));
		
		List<Integer> userList4 = criteria4.list();
		
		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserName("user5");
		// for any object , primary key and the field with null value will be ignored while searching. 
		Example example = Example.create(exampleUser).excludeProperty("userId");
		
		Criteria criteria5 = session.createCriteria(UserDetails.class)
									.add(example);
		List<UserDetails> userList5 = criteria5.list();
		
		UserDetails exampleUser1 = new UserDetails();
		exampleUser.setUserName("user1%");
		// for any object , primary key and the field with null value will be ignored while searching. 
		Example example1 = Example.create(exampleUser).excludeProperty("userId").enableLike();
		
		Criteria criteria6 = session.createCriteria(UserDetails.class)
									.add(example1);
		List<UserDetails> userList6 = criteria6.list();
		
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		
		System.out.println("************* Descending order *************");
		for(UserDetails user : userList){
			System.out.println(" "	+user.getUserName());
		}
		System.out.println("************* count Projection on Username *************");
		for(Long user : userList1){
			System.out.println(" "+user);
		}
		System.out.println("************* count Projection on UserId *************");
		for(Long user : userList2){
			System.out.println(" "+user);
		}
		System.out.println("************* Or clause restrictions *************");
		for(UserDetails user : userList3){
			System.out.println(" "+user.getUserName());
		}
		System.out.println("************* Property Projection on UserID(Column based pulling) *************");
		for(Integer user : userList4){
			System.out.println(" "+user);
		}
		System.out.println("************* example Object based Criteria *************");
		for(UserDetails user : userList5){
			System.out.println(" "+user.getUserName());
		}
		System.out.println("************* example Object based Criteria (with like)*************");
		for(UserDetails user : userList6){
			System.out.println(" "+user.getUserName());
		}
	}

	
}