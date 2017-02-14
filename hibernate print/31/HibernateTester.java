package org.rudra.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass31.OldStudent;

public class HibernateTester {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		OldStudent os1 =  new OldStudent(111, "rudra", "xyz@gmail.com", "somewhere on earth");
		OldStudent os2 =  new OldStudent(112, "rudra", "xyz@gmail.com", "somewhere on earth");
		OldStudent os3 =  new OldStudent(113, "rudra", "xyz@gmail.com", "somewhere on earth");
		
		session1.save(os1);
		session1.save(os2);
		session1.save(os3);
				
		String insertHql = "insert into NewStudent(id,name,email,address) select s.id,s.name,s.email,s.address from OldStudent s";
		Query q=session1.createQuery(insertHql);
		int i = q.executeUpdate();
		System.out.println(" number of rows affected : "+i);
				
		String updateHql = "update OldStudent set id=124,name='abhishek' where id=112";
		Query q1=session1.createQuery(updateHql);
		int i1 = q1.executeUpdate();
		System.out.println(" number of rows affected : "+i1);
				
		String deleteHql = "delete OldStudent where id=113";
		Query q2=session1.createQuery(deleteHql);
		int i2 = q2.executeUpdate();
		System.out.println(" number of rows affected : "+i2);
		
		String selectHql = "Select name,email from NewStudent";
		Query q3=session1.createQuery(selectHql);
		List q3_list = q3.list();
		System.out.println(" selected list object : ");
		for(Object obj : q3_list){
			Object arr[] = (Object[])obj;
			for(Object val:arr){
				System.out.print(" "+val);
			}
			System.out.println();
		}
				
		String aggregateHql = "Select max(id) from NewStudent";
		Query q4=session1.createQuery(aggregateHql);
		int max_id = (int) q4.uniqueResult();
		System.out.println(" max id from NewStudent Table :  "+max_id);
				
		session1.getTransaction().commit();
		session1.close();
		
		sessionFactory.close();
	
	}

	
}